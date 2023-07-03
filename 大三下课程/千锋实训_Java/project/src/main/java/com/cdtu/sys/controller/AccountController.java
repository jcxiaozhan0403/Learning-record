package com.cdtu.sys.controller;

import com.cdtu.sys.service.IAccountService;
import com.cdtu.sys.service.impl.AccountServiceImpl;
import com.cdtu.sys.utils.ResultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author:千锋强哥
 * @organization: 千锋教研院
 * @Version: 1.0
 *
 * localhost:8080/rental_B/account/transfer.action?inName=rose&outName=tom&money=10
 */
@Controller
@RequestMapping("account")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    /**
     * 返回统一的ResultObj对象 ，参数3个  inName outName money
     */
    @RequestMapping("transfer")
    @ResponseBody
    public ResultObj transfer(String inName , String outName , double money){

        int flag = accountService.updateTransfer(inName, outName, money);
        if(flag > 0){
            return ResultObj.UPDADTE_SUCCESS;
        }else{
            return ResultObj.UPDATE_ERROR;
        }
    }
}
