package com.vue_spring.controller;

import com.vue_spring.dao.AdminDao;
import com.vue_spring.dao.AdminDaoImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
@CrossOrigin //解决跨域问题
public class Controllers {

    @ResponseBody
    @RequestMapping("/validation") //传参
    public Boolean test(@RequestParam String name,@RequestParam String pwd) {
        AdminDao adminDao = new AdminDaoImpl();

        String pwdInDB = adminDao.validation(name);
        
        if (pwd.equals(pwdInDB)){
            return true;
        }else {
            return false;
        }
    }
}