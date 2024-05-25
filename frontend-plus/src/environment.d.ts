declare global {
  namespace NodeJS {
    interface ProcessEnv {
      VUE_APP_AUTH_BACKEND_URL: string
      VUE_APP_AUTH_TOKEN_NAME: string
      VUE_APP_AUTH_URL: string
      VUE_APP_FRONTEND_URL: string
      VUE_APP_BACKEND_URL: string
      NODE_ENV: string
    }
  }
}
export {}
