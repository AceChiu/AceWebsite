import { authAxiosInstance } from '../axiosInstance'
import login from '../interface/login'
import user from '../interface/user'
const url = 'api/auth/'

export const getIsExistedUser = (username: string) => {
  return authAxiosInstance.get(`${url}` + 'isExistUser/' + username)
}

export const postLogin = (login: login) => {
  return authAxiosInstance.post(
    `${url}` + 'login',
    JSON.stringify({
      username: login.username,
      password: login.password
    })
  )
}

export const postRegister = (user: user) => {
  return authAxiosInstance.post(
    `${url}` + 'register',
    JSON.stringify({
      username: user.username,
      password: user.password,
      email: user.email,
      googleId: user.googleId,
      familyName: user.familyName,
      givenName: user.givenName,
      name: user.name
    })
  )
}
