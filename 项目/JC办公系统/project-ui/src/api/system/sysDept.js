import request from '@/utils/request';

/*
  部门管理相关的 API 请求函数
*/
const api_name = '/admin/system/sysDept';

export default {
  // 条件查询部门列表（带分页）
  getPageList(page, limit, searchObj) {
    return request({
      url: `${api_name}/${page}/${limit}`,
      method: 'get',
      params: searchObj // URL 查询字符串或表单键值对
    });
  },

  // 根据 ID 获取部门
  getById(id) {
    return request({
      url: `${api_name}/get/${id}`,
      method: 'get'
    });
  },

  // 新增部门
  save(dept) {
    return request({
      url: `${api_name}/save`,
      method: 'post',
      data: dept
    });
  },

  // 更新部门
  updateById(dept) {
    return request({
      url: `${api_name}/update`,
      method: 'put',
      data: dept
    });
  },

  // 删除部门
  removeById(id) {
    return request({
      url: `${api_name}/remove/${id}`,
      method: 'delete'
    });
  },

  // 更新部门状态
  updateStatus(id, status) {
    return request({
      url: `${api_name}/updateStatus/${id}/${status}`,
      method: 'get'
    });
  }
};