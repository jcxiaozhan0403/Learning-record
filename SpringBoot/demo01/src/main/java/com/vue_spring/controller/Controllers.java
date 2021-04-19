package com.vue_spring.controller;

import com.vue_spring.dao.AdminDao;
import com.vue_spring.dao.AdminDaoImpl;
import com.vue_spring.users.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

@Controller
@RequestMapping("/api")
@CrossOrigin //解决跨域问题
public class Controllers {

//    @ResponseBody
//    @RequestMapping("/validation") //传参
//    public Boolean test(@RequestParam String name,@RequestParam String pwd) {
//        AdminDao adminDao = new AdminDaoImpl();
//
//        String pwdInDB = adminDao.validation(name);
//
//        if (pwd.equals(pwdInDB)){
//            return true;
//        }else {
//            return false;
//        }
//    }

//    @ResponseBody
//    @RequestMapping("/111") //传参
//    public Object sss() {
//        AdminDao adminDao = new AdminDaoImpl();
//
//        Users sss = new Users();
//        sss = adminDao.validation("nihao");
//
//        System.out.println(sss.toString());
//
//        return sss;
//    }


    @ResponseBody
    @RequestMapping("/111") //传参
    public Vector<Vector<Object>> sss() {
        Vector<Vector<Object>> data = null;

        AdminDao adminDao = new AdminDaoImpl();

        data = adminDao.validation("name");

        return data;
    }
}