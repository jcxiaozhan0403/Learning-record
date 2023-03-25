package com.jc.auth.controller;

import com.jc.common.result.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author John.Cena
 * @date 2023/3/25 20:32
 * @Description:
 */
class SysRoleControllerTest {
    @Autowired
    SysRoleController controller;

    @Test
    void pageQueryRole() {
        Result result = controller.pageQueryRole((long)1, (long)10, null);
        System.out.println(result);
    }
}
