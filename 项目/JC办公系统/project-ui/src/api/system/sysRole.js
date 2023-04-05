import request from '@/utils/request'

/*
    角色管理相关的API请求函数
*/
const api_name = '/admin/system/sysRole'

export default {
    //条件查询(带分页)
    getPageList(page, limit, searchObj) {
        return request({
            url: `${api_name}/${page}/${limit}`,
            method: 'get',
            params: searchObj
        })
    },

    //删除角色
    removeById(id) {
        return request({
            url: `${api_name}/remove/${id}`,
            method: 'delete'
        })
    },

    //新增角色
    save(role) {
        return request({
            url: `${api_name}/save`,
            method: 'post',
            data: role
        })
    },

    //根据id获取角色
    getById(id) {
        return request({
            url: `${api_name}/get/${id}`,
            method: 'get'
        })
    },

    //修改角色
    updateById(role) {
        return request({
            url: `${api_name}/update`,
            method: 'put',
            data: role
        })
    },

    //根据id批量删除角色
    batchRemove(idList) {
        return request({
          url: `${api_name}/batchRemove`,
          method: `delete`,
          data: idList
        })
    },

    //根据用户id获取角色集
    getRoles(userId) {
        return request({
          url: `${api_name}/toAssign/${userId}`,
          method: 'get'
        })
    },
      
    //给用户分配角色
    assignRoles(assginRoleVo) {
        return request({
            url: `${api_name}/doAssign`,
            method: 'post',
            data: assginRoleVo
        })
    }
}