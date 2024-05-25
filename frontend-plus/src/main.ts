import { createApp } from 'vue'
import router from './router'
import App from './App.vue'
// import ElementPlus from 'element-plus'
import { authAxiosInstance } from './util/axiosInstance'
import pinia from './store/store'
import i18n from './config/i18n'
import './styles/index.scss'
import 'uno.css'

// If you want to use ElMessage, import it.
import 'element-plus/theme-chalk/src/message.scss'
// import '~/styles/element/index.scss'

// import all element css, uncommented next line
import 'element-plus/dist/index.css'
import gAuthPlugin from 'vue3-google-oauth2';

const app = createApp(App)
const gauthClientId = "768834812579-ivi0oopbkqe05cg6t41p83t7gteekut6.apps.googleusercontent.com";
app.use(gAuthPlugin, { clientId: gauthClientId, scope: 'email', prompt: 'consent', fetch_basic_profile: false })
app.config.globalProperties.$authAxios = { ...authAxiosInstance }
app.use(pinia)
app.use(router)
app.mount('#app')
app.use(i18n)
