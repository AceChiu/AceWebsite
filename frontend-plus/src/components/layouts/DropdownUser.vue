<template>
  <el-dropdown @command="handleCommand" class="dropdown-user">
    <span class="el-dropdown-link" v-if="isDesktop">
      Welcome, {{ user.username }}<el-icon class="el-icon--right"><arrow-down /></el-icon>
    </span>
    <span v-else class="el-dropdown-link"
      ><el-icon size="20"><Avatar /></el-icon
    ></span>
    <template #dropdown>
      <!-- <el-dropdown-menu>
        <el-dropdown-item command="logout">Logout</el-dropdown-item>
        <el-dropdown-item command="switchUser">Switch User</el-dropdown-item>
      </el-dropdown-menu> -->

      <el-dropdown-menu>
        <el-dropdown-item command="login">Login</el-dropdown-item>
        <el-dropdown-item command="switchUser">Switch User</el-dropdown-item>
      </el-dropdown-menu>
    </template>
  </el-dropdown>
</template>
<script lang="ts" setup>
import { computed, ref, onMounted } from 'vue'
import { ElMessage, ElMessageBox } from 'element-plus'
import { ArrowDown, Avatar } from '@element-plus/icons-vue'
import { base } from '../../store/base'
import { useRouter } from 'vue-router'
import { getCurrentUser, putSwitchUser } from '../../util/api/auth'
import Cookies from 'js-cookie'
import { installGoogleAuth } from '../../util/GoogleAuth';

const router = useRouter()
const baseI = base()

const windowWidth = ref(0)
let gAuth: any;
const user = ref({});
const options = {
  // clientId: `${process.env.GOOGLE_CLIENT_ID}.apps.googleusercontent.com`,
  clientId: '768834812579-ivi0oopbkqe05cg6t41p83t7gteekut6.apps.googleusercontent.com',
  scope: 'profile email',
  prompt: 'select_account'
};

const handleClickSignIn = () =>  {
  console.log('handleClickSignIn')
  if (!gAuth) return;
  gAuth.then(function(result: any) {
    result.signIn()
      .then((googleUser: any) => {
        console.log(googleUser)
        console.log(googleUser.Tc)
        console.log(googleUser.Tc.id_token)
        user.value = {
          "access_token": googleUser.Tc.access_token,
          "expires_at": googleUser.Tc.expires_at,
          "id_token": googleUser.Tc.id_token,
          "username": googleUser.ly.ig,
          "email": googleUser.ly.ez
        }
      })
      .catch((e: any) => {
        console.log('error', e);
      });
  })
}

onMounted(async () => {
  console.log('onMounted')
  gAuth = installGoogleAuth(options);
  console.log(gAuth)
});
  
// async handleClickGetAuthCode(){
//   try {
//     const authCode = await this.$gAuth.getAuthCode();
//     console.log("authCode", authCode);
//   } catch(error) {
//     //on fail do something
//     console.error(error);
//     return null;
//   }
// }
  
// async handleClickSignOut() {
//   try {
//     await this.$gAuth.signOut();
//     console.log("isAuthorized", this.Vue3GoogleOauth.isAuthorized);
//     this.user = "";
//   } catch (error) {
//     console.error(error);
//   }
// }
  
// handleClickDisconnect() {
//   window.location.href = `https://www.google.com/accounts/Logout?continue=https://appengine.google.com/_ah/logout?continue=${window.location.href}`;
// }
const handleCommand = (command: string | number | object) => {
  if (command === "login") {
    handleClickSignIn();
  } else if (command === 'logout') {
    Cookies.remove(import.meta.env.VITE_APP_AUTH_TOKEN_NAME)
    router.push({ name: 'home' })
  } else {
    ElMessageBox.prompt('Please input User Account', {
      confirmButtonText: 'OK',
      cancelButtonText: 'Cancel'
    })
      .then(({ value }) => {
        baseI.setLoading(true)
        putSwitchUser(value)
          .then((response: any) => {
            Cookies.set(import.meta.env.VITE_APP_AUTH_TOKEN_NAME, response.data.access_token, {
              expires: 1000 * 60 * 60 * 6
            })
            getCurrentUser()
              .then((response: any) => {
                baseI.setUser(response.data)
              })
              .catch((error: any) => {
                baseI.setLogin(false)
                Cookies.remove(import.meta.env.VITE_APP_AUTH_TOKEN_NAME)
                console.error(error)
              })
          })
          .catch((error: any) => {
            ElMessageBox.alert(error.response.data.messages[1], error.response.data.messages[0])
          })
          .finally(() => {
            baseI.setLoading(false)
          })
      })
      .catch(() => {
        ElMessage({
          type: 'info',
          message: 'Input canceled'
        })
      })
  }
}
const isDesktop = computed(() => windowWidth.value >= 768)
window.addEventListener('resize', () => {
  windowWidth.value = document.documentElement.clientWidth
})
onMounted(() => {
  windowWidth.value = document.documentElement.clientWidth
})
</script>
<style lang="scss">
.dropdown-user {
  color: #fff !important;
  font-size: 14px;
  cursor: pointer;
}
</style>
