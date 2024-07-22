import { authAxiosInstance } from '../axiosInstance'
import user from '../interface/user'
const url = 'api/user-profile/'

export const getCurrentUser = () => {
  return authAxiosInstance.get(`${url}` + 'current-user')
}

export const postUpdateUser = (user: user) => {
  return authAxiosInstance.post(
    `${url}` + 'update',
    JSON.stringify({
      id: user.id,
      username: user.username,
      birthday: user.birthday,
      phone: user.phone,
      address: user.address
    })
  )
}
