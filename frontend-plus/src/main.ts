import { createApp } from 'vue'
import router from './router'
import App from './App.vue'
// import ElementPlus from 'element-plus'
import { authAxiosInstance } from './util/axiosInstance'
import pinia from './store/store'
import i18n from './config/i18n'
import vue3GoogleLogin from 'vue3-google-login'
import './styles/index.scss'
import 'uno.css'

// If you want to use ElMessage, import it.
import 'element-plus/theme-chalk/src/message.scss'
// import '~/styles/element/index.scss'

// import all element css, uncommented next line
import 'element-plus/dist/index.css'

const app = createApp(App)
app.config.globalProperties.$authAxios = { ...authAxiosInstance }
app.use(pinia)
app.use(router)
app.use(i18n)
app.use(vue3GoogleLogin, {
    clientId: '429767660564-5hum32kmibduum3ep3ia83ec3p49tgnn.apps.googleusercontent.com'
})
app.mount('#app')
