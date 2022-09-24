package com.controller;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author John.Cena
 * @date 2022/9/24 17:59
 * @Description:
 */
@Controller
public class IndexController {

    @RequestMapping(value = {"/index","/"})
    public String index(){
        return "index";
    }

    @RequestMapping("/main/hello")
    public String hello(){
        return "main/hello";
    }
}
