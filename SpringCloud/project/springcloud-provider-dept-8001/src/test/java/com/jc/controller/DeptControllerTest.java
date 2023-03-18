package com.jc.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author John.Cena
 * @date 2023/3/18 17:06
 * @Description:
 */
@SpringBootTest
class DeptControllerTest {
    @Autowired
    DeptController deptController;

    @Test
    void queryAll() {
        System.out.println(deptController.queryAll());
    }
}
