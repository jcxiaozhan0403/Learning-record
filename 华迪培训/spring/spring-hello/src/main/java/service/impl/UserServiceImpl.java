package service.impl;

import dao.UserDao;
import service.UserService;

public class UserServiceImpl implements UserService {
//    private UserDao userDao = new UserDaoImpl1();
//    private UserDao userDao = new UserDaoImpl2();

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String show() {
        String show = userDao.show();
        return show;
    }
}
