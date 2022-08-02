package com.cheng.test;

import com.cheng.dao.UserMapper;
import com.cheng.pojo.Bill;
import com.cheng.pojo.Role;
import com.cheng.pojo.User;
import com.cheng.service.BillService;
import com.cheng.service.Impl.UserServiceImpl;
import com.cheng.service.UserService;
import org.apache.ibatis.jdbc.Null;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestDemo {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private BillService billService;

    @Test
    public void text1(){
        List<User> users = userMapper.getUserList(null, 1,1,5);
        for (User user:users) {
            System.out.println(user);
        }

        int count = userService.getUserCount(null,2);
        System.out.println(users);

    }

    @Test
    public void text2(){
        List<Bill> billList = billService.getBillList();
        for (Bill bill:billList
             ) {
            System.out.println(bill);
        }
    }
}
