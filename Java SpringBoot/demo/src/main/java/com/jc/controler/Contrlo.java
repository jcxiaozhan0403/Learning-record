package com.jc.controler;

import com.jc.dao.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
@CrossOrigin //解决跨域问题
public class Contrlo {

    @ResponseBody
    @RequestMapping("/test")
    //传参
    public String test(@RequestParam String name) {
        String pwd = Test.find(name);
        return pwd;
    }
}
