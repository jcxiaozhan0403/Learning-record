package cn.com.service.user.impl;

import cn.com.dao.user.UserDao;
import cn.com.dao.user.impl.UserDaoImpl;
import cn.com.pojo.User;
import cn.com.service.user.UserService;

/**
 * @author John.Cena
 * @date 2022/8/2 17:39
 * @Description:
 */
public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    public User getUser(String userCode) {
        return userDao.getUser(userCode);
    }

    public int updatePwd(String userCode, String newpassword) {
        return userDao.updatePwd(userCode,newpassword);
    }
}
