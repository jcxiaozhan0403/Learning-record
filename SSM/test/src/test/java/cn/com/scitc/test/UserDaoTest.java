package cn.com.scitc.test;

import cn.com.scitc.test.dao.UserDao;
import cn.com.scitc.test.pojo.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserDaoTest {

    @Test
    void findById() {
        UserDao userDao = new UserDao();
        User user = userDao.findById(1);
        System.out.println(user.getName());
        Assertions.assertArrayEquals("李爽",user.getName());
    }
}