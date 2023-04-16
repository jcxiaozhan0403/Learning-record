package com.jc.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author John.Cena
 * @date 2023/4/16 13:05
 * @Description:
 */
@SpringBootTest
class SysMenuServiceImplTest {
    @Autowired
    SysMenuServiceImpl sysMenuServiceImpl;

    @Test
    public void demo() {
        System.out.println(sysMenuServiceImpl.findSysMenuByRoleId(1l));
    }

}
