package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author John.Cena
 * @date 2022/9/1 9:57
 * @Description:
 */
@RestController
public class LoginController {

    @RequestMapping("/demo")
    public String myTest(@RequestParam("lecturer") String lecturer){

        if(lecturer.equals("null")){
            System.out.println("1111111111111111111111111");
        }else{
            System.out.println("22222222222222222222");
        }

        return "demo";
    }
}
