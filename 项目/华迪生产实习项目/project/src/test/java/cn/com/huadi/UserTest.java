package cn.com.huadi;

import cn.com.huadi.entity.Role;
import cn.com.huadi.entity.User;
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

    @Test
    public void user(){
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper
//                .ge("name","zhangsan")
//                .ge("pwd","123")
//                .ge("role","1");
//
//        User one = userService.getOne(queryWrapper);
//        System.out.println(one);
//
//        Role byId = roleService.getById(1);
//
//        System.out.println(byId);


    }
}
