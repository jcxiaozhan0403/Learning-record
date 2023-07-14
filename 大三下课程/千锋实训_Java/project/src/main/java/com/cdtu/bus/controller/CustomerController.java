package com.cdtu.bus.controller;

import com.cdtu.bus.domain.CustomerVo;
import com.cdtu.bus.service.ICustomerService;
import com.cdtu.sys.utils.DataGridView;
import com.cdtu.sys.utils.ResultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    /**
     * 跳转到客户管理也买你
     * ../bus/toCustomerManager.action
     */
    @RequestMapping("toCustomerManager")
    public String toCustomer(){
        return "business/customer/customerManager";
    }

    /**
     * 分页查询客户信息
     * 参数： CustomerVo
     * 返回值：DataGridView
     */
    @ResponseBody
    @RequestMapping("loadAllCustomer")
    public DataGridView loadAllCustomer(CustomerVo customerVo){
        try {
            return customerService.selectCustomer(customerVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 添加客户
     */
    @RequestMapping("addCustomer")
    @ResponseBody
    public ResultObj addCustomer(CustomerVo customerVo){
        try {
            customerVo.setCreatetime(new Date());
            this.customerService.addCustomer(customerVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 删除客户信息
     */
    @RequestMapping("deleteCustomer")
    @ResponseBody
    public ResultObj deleteCustomer(String identity){
        try {
            customerService.deleteCustomerById(identity);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 修改客户信息
     */
    @RequestMapping("updateCustomer")
    @ResponseBody
    public ResultObj updateCustomer(CustomerVo customerVo){
        try {
            customerService.updateCustomer(customerVo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    /**
     * 批量删除客户信息
     */
    @RequestMapping("deleteBatchCustomer")
    @ResponseBody
    public ResultObj deleteBatchCustomer(CustomerVo customerVo){
        try {
            customerService.deleteBatchCustomer(customerVo.getIds());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
}
