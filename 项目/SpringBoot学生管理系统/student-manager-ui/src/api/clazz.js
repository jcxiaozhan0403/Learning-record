import request from '@/utils/request'

// 班级列表
export function listClazz(){
  return request({
    url: '/clazz/list',
    method: 'get'
  })
}

// 更新班级
export function updateClazz(data){
  return request({
    url: '/clazz/update',
    method: 'post',
    data
  })
}

// 删除班级
export function deleteClazz(id){
  return request({
    url: '/clazz/delete/' + id,
    method: 'post'
  })
}

// 添加班级
export function addClazz(data){
  return request({
    url: '/clazz/add/',
    method: 'post',
    data
  })
}

// 年级列表
export function getGrades(){
  return request({
    url: '/clazz/grades',
    method: 'get'
  })
}

// 根据年级获取班级
export function getClazzs(grade){
  return request({
    url: '/clazz/clazzs?grade=' + grade,
    method: 'get',
  })
}