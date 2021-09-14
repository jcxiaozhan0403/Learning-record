import request from '@/utils/request'

export function login(data) {
  return request({
    url: '/user/login',
    method: 'post',
    data
  })
}

export function getInfo(token) {
  return request({
    url: '/user/info',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: '/user/logout',
    method: 'post'
  })
}

export function updateUserInfo(data) {
  return request({
    url: '/user/info/update',
    method: 'post',
    data
  })
}

export function updateUserPassword(data) {
  return request({
    url: '/user/info/updatePassword',
    method: 'post',
    data
  })
}