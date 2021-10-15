import request from '@/utils/request'

// 登录验证
export function login(data) {
  return request({
    url: '/user/login',
    method: 'post',
    data
  })
}

// 获取用户信息
export function getInfo(token) {
  return request({
    url: '/user/info',
    method: 'get',
    params: { token }
  })
}

// 注销
export function logout() {
  return request({
    url: '/user/logout',
    method: 'post'
  })
}

// 更新用户信息
export function updateUserInfo(data) {
  return request({
    url: '/user/info/update',
    method: 'post',
    data
  })
}

// 更新密码
export function updateUserPassword(data) {
  return request({
    url: '/user/info/updatePassword',
    method: 'post',
    data
  })
}