package com.jc.controller;

import com.jc.model.system.SysUser;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpServletRequest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author John.Cena
 * @date 2023/7/18 11:13
 * @Description:
 */
@SpringBootTest
class IndexControllerTest {
    @Autowired
    private IndexController indexController;

//    @Test
//    void loginSuccess() {
//        SysUser user = new SysUser();
//        user.setUsername("Admin");
//        indexController.loginSuccess(user);
//    }
}
