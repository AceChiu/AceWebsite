import { authAxiosInstance } from '../axiosInstance'
const url = '/auth/'

export const getCurrentUser = () => {
  return authAxiosInstance.get(`${url}` + 'current-user')
}
export const putSwitchUser = (username: string) => {
  return authAxiosInstance.put(
    `${url}` + 'switch-user',
    JSON.stringify({
      username: username
    })
  )
}
