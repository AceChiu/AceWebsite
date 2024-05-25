import { describe, it, assert } from 'vitest'
import { setCookie } from '../../util/cookie'

describe('test element_plus_vite_starter', function () {
  it('test element-plus-vite-starter.getCookie', function () {
    assert.equal(setCookie('myCookie', 'test', 1000), undefined)
  })
})
