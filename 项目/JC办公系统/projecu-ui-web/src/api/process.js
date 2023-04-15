import request from '@/utils/request'

const api_name = '/admin/process'

export default {

  //查找审批列表
  findProcessType() {
    return request({
      url: `${api_name}/findProcessType`,
      method: 'get'
    })
  },

  //根据id获取某一模板的表单
  getProcessTemplate(processTemplateId) {
    return request({
      url: `${api_name}/getProcessTemplate/`+processTemplateId,
      method: 'get'
    })
  },

  startUp(processFormVo) {
    return request({
      url: `${api_name}/startUp`,
      method: 'post',
      data: processFormVo
    })
  },

  //获取待处理列表
  findPending(page, limit) {
    return request({
      url: `${api_name}/findPending/`+page+`/`+ limit,
      method: 'get'
    })
  },

  show(id) {
    return request({
      url: `${api_name}/show/`+id,
      method: 'get'
    })
  },

  approve(approvalVo) {
    return request({
      url: `${api_name}/approve`,
      method: 'post',
      data: approvalVo
    })
  },


  findProcessed(page, limit) {
    return request({
      url: `${api_name}/findProcessed/`+page+`/`+ limit,
      method: 'get'
    })
  },

  findStarted(page, limit) {
    return request({
      url: `${api_name}/findStarted/`+page+`/`+ limit,
      method: 'get'
    })
  },



}
