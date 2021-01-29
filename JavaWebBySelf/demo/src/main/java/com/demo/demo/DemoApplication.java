package com.demo.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("hello")
public class DemoApplication {
    @RequestMapping("hello")
    @ResponseBody
    public String hello(){
        System.out.println("Hello SpringBoot");
        return "/templates/index.html";
    }
}
