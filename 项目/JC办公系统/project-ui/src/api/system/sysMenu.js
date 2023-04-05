import request from '@/utils/request'

/*
  菜单管理相关的API请求函数
*/
const api_name = '/admin/system/sysMenu'

export default {

  //获取菜单
  findNodes() {
    return request({
      url: `${api_name}/findNodes`,
      method: 'get'
    })
  },

  //删除菜单
  removeById(id) {
    return request({
      url: `${api_name}/remove/${id}`,
      method: "delete"
    })
  },

  //新增菜单
  save(sysMenu) {
    return request({
      url: `${api_name}/save`,
      method: "post",
      data: sysMenu
    })
  },

  //修改菜单
  updateById(sysMenu) {
    return request({
      url: `${api_name}/update`,
      method: "put",
      data: sysMenu
    })
  },

  //根据角色id获取菜单集
  toAssign(roleId) {
    return request({
      url: `${api_name}/toAssign/${roleId}`,
      method: 'get'
    })
  },

  //给角色分配权限
  doAssign(assginMenuVo) {
    return request({
      url: `${api_name}/doAssign`,
      method: "post",
      data: assginMenuVo
    })
  }
}