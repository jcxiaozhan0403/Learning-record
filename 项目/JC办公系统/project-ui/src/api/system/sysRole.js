/*
    角色管理相关的API请求函数
*/
import request from '@/utils/request'

const api_name = '/admin/system/sysRole'

export default {
    //获取角色分页列表(带搜索)
    getPageList(page, limit, searchObj) {
        return request({
            url: `${api_name}/${page}/${limit}`,
            method: 'get',
            params: searchObj
        })
    },

    //根据ID删除角色
    removeById(id) {
        return request({
            url: `${api_name}/remove/${id}`,
            method: 'delete'
        })
    },

    //添加角色
    save(role) {
        return request({
            url: `${api_name}/save`,
            method: 'post',
            data: role
        })
    },

    //根据ID获取角色信息
    getById(id) {
        return request({
            url: `${api_name}/get/${id}`,
            method: 'get'
        })
    },

    //更新角色信息
    updateById(role) {
        return request({
            url: `${api_name}/update`,
            method: 'put',
            data: role
        })
    },
    //根据ID批量删除
    batchRemove(idList) {
        return request({
          url: `${api_name}/batchRemove`,
          method: `delete`,
          data: idList
        })
    },
    //根据ID获取角色列表
    getRoles(userId) {
        return request({
          url: `${api_name}/toAssign/${userId}`,
          method: 'get'
        })
    },
      
    //根据ID分配角色
    assignRoles(assginRoleVo) {
        return request({
            url: `${api_name}/doAssign`,
            method: 'post',
            data: assginRoleVo
        })
    }
}