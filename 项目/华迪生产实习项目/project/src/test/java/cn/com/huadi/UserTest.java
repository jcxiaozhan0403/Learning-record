package cn.com.huadi;

import cn.com.huadi.controller.CurriculumController;
import cn.com.huadi.entity.Role;
import cn.com.huadi.entity.User;
import cn.com.huadi.service.impl.CurriculumService;
import cn.com.huadi.service.impl.RoleService;
import cn.com.huadi.service.impl.UserService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.rmi.server.RemoteServer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class UserTest {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @Autowired
    CurriculumService curriculumService;

    @Test
    public void user(){

    }
}
