package com.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author John.Cena
 * @date 2023/7/19 14:42
 * @Description:
 */
@RestController
public class HelloController {
    @Value("${name}")
    private String name;


    @RequestMapping("/test")
    public String test(){
        return name;
    }
}
