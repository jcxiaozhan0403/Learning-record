import request from '@/utils/request'

// 教师列表
export function listTeacher(){
  return request({
    url: '/teacher/list',
    method: 'get'
  })
}

// 添加教师
export function addTeacher(data){
  return request({
    url: '/teacher/add',
    method: 'post',
    data
  })
}

// 更新教师
export function updateTeacher(data){
  return request({
    url: '/teacher/update',
    method: 'post',
    data
  })
}

// 删除教师
export function deleteTeacher(id){
  return request({
    url: '/teacher/delete/' + id,
    method: 'post'
  })
}

// 搜索教师
export function searchTeacher(data){
  return request({
    url: '/teacher/search',
    method: 'post',
    data
  })
}