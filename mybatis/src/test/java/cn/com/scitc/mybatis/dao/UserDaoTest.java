package cn.com.scitc.mybatis.dao;

import cn.com.scitc.mybatis.pojo.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    @Test
    void findById() {
        UserDao userDao = new UserDao();
        User user = userDao.findById(1);
        System.out.println(user.getName());
        Assertions.assertEquals("李爽",user.getName());
    }
}