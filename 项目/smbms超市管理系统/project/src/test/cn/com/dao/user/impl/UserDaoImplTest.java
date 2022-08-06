package cn.com.dao.user.impl;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author John.Cena
 * @date 2022/8/5 9:29
 * @Description:
 */
public class UserDaoImplTest {

    @Test
    public void getTotalCount() {
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.getTotalCount();
    }
}