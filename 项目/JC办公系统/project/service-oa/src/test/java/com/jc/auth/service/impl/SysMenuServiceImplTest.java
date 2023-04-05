package com.jc.auth.service.impl;

import com.jc.auth.service.SysMenuService;
import com.jc.model.system.SysMenu;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author John.Cena
 * @date 2023/4/5 12:46
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class SysMenuServiceImplTest {

    @Autowired
    private SysMenuService sysMenuService;

    @Test
    public void testSeervice(){
        List<SysMenu> list = sysMenuService.list();
        System.out.println(list);
    }
}
