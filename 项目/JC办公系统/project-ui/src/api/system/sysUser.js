import request from '@/utils/request'

/*
    用户管理相关的API请求函数
*/
const api_name = '/admin/system/sysUser'

export default {

    //条件查询(带分页)
    getPageList(page, limit, searchObj) {
        return request({
            url: `${api_name}/${page}/${limit}`,
            method: 'get',
            params: searchObj // url查询字符串或表单键值对
        })
    },
    
    //根据id获取用户
    getById(id) {
        return request({
            url: `${api_name}/get/${id}`,
            method: 'get'
        })
    },

    //新增用户
    save(role) {
        return request({
            url: `${api_name}/save`,
            method: 'post',
            data: role
        })
    },

    //更新用户
    updateById(role) {
        return request({
            url: `${api_name}/update`,
            method: 'put',
            data: role
        })
    },
    
    //删除用户
    removeById(id) {
        return request({
            url: `${api_name}/remove/${id}`,
            method: 'delete'
        })
    },

    //更新用户状态
    updateStatus(id, status) {
        return request({
          url: `${api_name}/updateStatus/${id}/${status}`,
          method: 'get'
        })
    },

    //重置密码
    resetPwd(id){
        return request({
            url: `${api_name}/resetPwd/${id}`,
            method: 'put'
        })
    }
}