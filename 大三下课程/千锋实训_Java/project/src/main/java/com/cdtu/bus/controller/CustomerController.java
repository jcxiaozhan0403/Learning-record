package com.cdtu.bus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author:千锋强哥
 * @organization: 千锋教研院
 * @Version: 1.0
 */

@Controller
@RequestMapping("bus")
public class CustomerController {

    /**
     * 跳转到客户管理也买你
     * ../bus/toCustomerManager.action
     */
    @RequestMapping("toCustomerManager")
    public String toCustomer(){
        return "business/customer/customerManager";
    }

}
