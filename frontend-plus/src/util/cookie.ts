function setCookie (cookieName: string, value: string, expireDays: number) {
  const expirationDate = new Date()
  expirationDate.setTime(expirationDate.getTime() + expireDays)

  document.cookie =
    cookieName +
    '=' +
    encodeURIComponent(value) +
    (expireDays == null ? '' : ';expires=' + expirationDate.toUTCString()) +
    ';path=/;secure;domain=' +
    process.env.VUE_APP_DOMAIN
}

function getCookie (name: string) {
  let arr
  const reg = new RegExp('(^| )' + name + '=([^;]*)(;|$)')
  if ((arr = document.cookie.match(reg))) {
    return arr[2]
  } else {
    return null
  }
}

const delCookie = (name: string) => {
  const exp = new Date()
  exp.setTime(exp.getTime() - 1)
  const cval = getCookie(name)
  if (cval != null) {
    document.cookie =
      name +
      '=;expires=' +
      exp.toUTCString() +
      ';path=/;domain=' +
      process.env.VUE_APP_DOMAIN
  }
}

export { setCookie, getCookie, delCookie }
