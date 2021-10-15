import request from '@/utils/request'

// 学生列表
export function listStudent(){
  return request({
    url: '/student/list',
    method: 'get'
  })
}

// 添加学生
export function addStudent(data){
  return request({
    url: '/student/add',
    method: 'post',
    data
  })
}

// 更新学生
export function updateStudent(data){
  return request({
    url: '/student/update',
    method: 'post',
    data
  })
}

//删除学生
export function deleteStudent(id){
  return request({
    url: '/student/delete/' + id,
    method: 'post'
  })
}

// 搜索学生
export function searchStudent(data){
  return request({
    url: '/student/search',
    method: 'post',
    data
  })
}