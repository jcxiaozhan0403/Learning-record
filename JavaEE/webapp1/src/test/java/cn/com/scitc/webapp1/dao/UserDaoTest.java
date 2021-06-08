package cn.com.scitc.webapp1.dao;

import cn.com.scitc.webapp1.pojo.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    UserDao userDao = new UserDao();
    @Test
    void findAll() {

        List<User> userList = userDao.findAll();
        System.out.println(userList);
    }

    @Test
    void findById() {
        User user = userDao.findById(1);
        System.out.println(user);
    }

    @Test
    void insert() {
        userDao.insert("Admin001","李四","13685247624");
    }

    @Test
    void update() {
        userDao.update("JohnCena","王五","15984267843");
    }
}