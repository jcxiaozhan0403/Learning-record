package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author John.Cena
 * @date 2022/9/7 9:54
 * @Description:
 */
@Controller
public class HelloController {

    @RequestMapping(value = {"/index","/","login"})
    public String index(){
        return "index";
    }
}
