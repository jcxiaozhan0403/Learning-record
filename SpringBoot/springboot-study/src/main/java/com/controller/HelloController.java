package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author John.Cena
 * @date 2022/9/7 9:54
 * @Description:
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "你好世界！";
    }

}
