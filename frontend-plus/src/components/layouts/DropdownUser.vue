<template>
  <span class="username" v-if="isDesktop && isLogin">
    {{ currentUser.name }}
  </span>
  <GoogleLogin :callback="callback" v-if="isDesktop && !isLogin" prompt />
</template>
<script lang="ts" setup>
import pinia from '../../store/store'
import user from '../../util/interface/user'
import login from '../../util/interface/login'
import Cookies from 'js-cookie'
import { base } from '../../store/base'
import { computed, ref, onMounted } from 'vue'
import { decodeCredential } from 'vue3-google-login'
import { getIsExistedUser, postRegister, postLogin } from '../../util/api/auth'
import { getCurrentUser } from '../../util/api/user-profile'
import { ElMessage } from 'element-plus'
const baseI = base(pinia)
const windowWidth = ref(0)

const loginDetail = ref<login>({
  username: '',
  password: ''
})

const userDetial = ref<user>({
  id: 0,
  username: '',
  password: '',
  email: '',
  googleId: '',
  name: '',
  familyName: '',
  givenName: '',
  birthday: new Date(),
  phone: '',
  address: ''
})

const callback = (response: any) => {
  const googleUser = decodeCredential(response.credential)
  loginDetail.value.username = googleUser.email
  loginDetail.value.password = googleUser.sub
  getIsExistedUser(loginDetail.value.username)
    .then((response: any) => {
      if (response.data) {
        loginAction(loginDetail.value)
      } else {
        userDetial.value.username = googleUser.email
        userDetial.value.password = googleUser.sub
        userDetial.value.email = googleUser.email
        userDetial.value.googleId = googleUser.sub
        userDetial.value.name = googleUser.name
        userDetial.value.familyName = googleUser.familyName
        userDetial.value.givenName = googleUser.givenName
        postRegister(userDetial.value).then((response: any) => {
          if (response.data) {
            loginAction(loginDetail.value)
          }
        })
      }
    })
    .catch((error: any) => {
      console.log(error)
    })
    .finally(() => {
      baseI.loading = false
    })
}

const loginAction = (loginDetail: login) => {
  postLogin(loginDetail).then((response: any) => {
    Cookies.set(import.meta.env.VITE_APP_AUTH_TOKEN_NAME, response.data.token, {
      expires: 1000 * 60 * 60 * 6
    })

    getCurrentUser()
      .then((response: any) => {
        console.log(response.data)
        baseI.setUser(response.data)
      })
      .catch((error: any) => {
        console.log(error)
        ElMessage.error({
          message: error,
          duration: 5000
        })
      })
      .finally(() => {
        baseI.loading = false
      })
  })
}

const isLogin = computed(() => (Object.keys(baseI.getUser)?.length === 0 ? false : true))
const currentUser = computed(() => baseI.getUser)
const isDesktop = computed(() => windowWidth.value >= 768)
window.addEventListener('resize', () => {
  windowWidth.value = document.documentElement.clientWidth
})
onMounted(() => {
  windowWidth.value = document.documentElement.clientWidth
})
</script>
<style lang="scss">
.username {
  color: gray;
  font-size: 28px;
  cursor: pointer;
}
</style>
