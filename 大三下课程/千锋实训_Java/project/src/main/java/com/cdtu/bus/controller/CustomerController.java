package com.cdtu.bus.controller;

import com.cdtu.bus.domain.CustomerVo;
import com.cdtu.bus.service.ICustomerService;
import com.cdtu.sys.utils.DataGridView;
import com.cdtu.sys.utils.ResultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author:千锋强哥
 * @organization: 千锋教研院
 * @Version: 1.0
 */

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
     * 添加客户的方法
     */
    @ResponseBody
    @RequestMapping("addCustomer")
    public ResultObj addCustomer(CustomerVo customerVo){
        try {
            customerService.addCustomer(customerVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 删除客户信息
     */
    @ResponseBody
    @RequestMapping("deleteCustomer")
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
     * 更新客户信息
     */
    @ResponseBody
    @RequestMapping("updateCustomer")
    public ResultObj updateCustomer(CustomerVo customerVo){
        try {
            customerService.updateCustomer(customerVo);
            return ResultObj.UPDADTE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }


    /**
     * 批量删除
     */
    @ResponseBody
    @RequestMapping("batchDeleteCustomer")
    public ResultObj batchDeleteCustomer(CustomerVo customerVo){
        try {
            customerService.deleteBatchCustomer(customerVo.getIds());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
}
