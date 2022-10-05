package com.controller;

import com.service.AsyncsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author John.Cena
 * @date 2022/10/5 10:36
 * @Description:
 */
@Controller
public class AsyncController {

    @Autowired
    AsyncsServiceImpl asyncsService;

    @ResponseBody
    @RequestMapping("/register")
    public String async(){
        asyncsService.async();
        return "注册成功";
    }

}
