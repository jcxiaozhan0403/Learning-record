package dao.impl;

import dao.UserDao;

public class UserDaoImpl1 implements UserDao {
    @Override
    public String show() {

        return "查询用户信息1";
    }
}
