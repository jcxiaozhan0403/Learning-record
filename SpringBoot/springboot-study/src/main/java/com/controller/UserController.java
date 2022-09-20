package com.controller;

import com.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author John.Cena
 * @date 2022/9/20 11:46
 * @Description:
 */
@RestController
public class UserController {
    @Autowired
    UserMapper userMapper;

    @RequestMapping("/list")
    public String list(){
        return userMapper.userList().toString();
    }
}
