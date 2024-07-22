import Cookies from 'js-cookie'
import axios, { AxiosError } from 'axios'
const axiosInstance = (
  baseURL: string,
  condtionPopMessageWhenError: (error: AxiosError) => boolean,
  condtionPopMessageWhenNotError: (error: AxiosError) => boolean
) => {
  const instance = axios.create({
    baseURL,
    headers: {
      'Content-type': 'application/json'
      // 'Authorization': 'Bearer ' + Cookies.get(import.meta.env.VITE_APP_AUTH_TOKEN_NAME)
    }
  })

  instance.interceptors.request.use(
    (config) => {
      // config.headers['Accept-Language'] = store.getters.getLanguage
      if (Cookies.get(import.meta.env.VITE_APP_AUTH_TOKEN_NAME)) {
        config.headers.Authorization =
          'Bearer ' + Cookies.get(import.meta.env.VITE_APP_AUTH_TOKEN_NAME)
      }
      config.headers['Content-Type'] = 'application/json'
      // store.commit(types.LOADING, true)
      return config
    },
    (error) => {
      return Promise.reject(error)
    }
  )

  instance.interceptors.response.use(
    (response) => {
      // store.commit(types.LOADING, false)
      return response
    },
    (error) => {
      if (error.response.status === 444 && condtionPopMessageWhenError(error)) {
        return Promise.reject(error)
      }

      if (error.response.status !== 444 && condtionPopMessageWhenNotError(error)) {
        return Promise.reject(error)
      }
      return Promise.reject(error)
    }
  )
  return instance
}

const authAxiosInstance = axiosInstance(
  import.meta.env.VITE_APP_BACKEND_URL,
  (error: Error | AxiosError) => {
    if (axios.isAxiosError(error)) {
      // Access to config, request, and response
      return true
    } else {
      // Just a stock error
      return true
    }
  },
  (error: Error | AxiosError) => {
    if (axios.isAxiosError(error)) {
      // Access to config, request, and response
      return true
    } else {
      // Just a stock error
      return true
    }
  }
)

export { authAxiosInstance }
