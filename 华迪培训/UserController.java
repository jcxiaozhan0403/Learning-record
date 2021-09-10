package com.huadi.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/user") //主入口
public class UserController {

    @RequestMapping(value = "/login")//打开登录页面
    public String register(){
         return "user/login";
    }

/*
路径绑定
 */
    @RequestMapping(value = "/doLogin/{userId}" ,method = RequestMethod.GET)
    public String login(@PathVariable("userId") int userid){
        System.out.println("userid = "+userid);
        return "user/success";
    }

 /*
 请求参数绑定
  */
    @RequestMapping(value = "/doLogin2")
    public String login2(@RequestParam("username")String UserName,
                         @RequestParam("password")String PassWord){
        if(UserName.equals("admin")&&PassWord.equals("123")){
            return "user/success";
        }
        else{
            return "user/fail";
        }
    }
}
