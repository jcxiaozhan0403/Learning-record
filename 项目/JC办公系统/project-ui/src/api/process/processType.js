import request from '@/utils/request'

const api_name = '/admin/process/processType'

export default {

  //获取审批类型列表数据（分页）
  getPageList(page, limit) {
    return request({
      url: `${api_name}/${page}/${limit}`,
      method: 'get'
    })
  },
  //获取单个审批类型
  getById(id) {
    return request({
      url: `${api_name}/get/${id}`,
      method: 'get'
    })
  },
  //添加审批类型
  save(role) {
    return request({
      url: `${api_name}/save`,
      method: 'post',
      data: role
    })
  },
  //修改审批类型
  updateById(role) {
    return request({
      url: `${api_name}/update`,
      method: 'put',
      data: role
    })
  },
  //删除审批类型
  removeById(id) {
    return request({
      url: `${api_name}/remove/${id}`,
      method: 'delete'
    })
  },
  //获取全部审批类型（审批模板设置时会使用到）
  findAll() {
    return request({
      url: `${api_name}/findAll`,
      method: 'get'
    })
  }
}