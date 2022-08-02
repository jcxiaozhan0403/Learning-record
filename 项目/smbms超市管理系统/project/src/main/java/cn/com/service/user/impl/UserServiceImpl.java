package cn.com.service.user.impl;

import cn.com.dao.user.impl.UserDaoImpl;
import cn.com.pojo.User;
import cn.com.service.user.UserService;

/**
 * @author John.Cena
 * @date 2022/8/2 17:39
 * @Description:
 */
public class UserServiceImpl implements UserService {

    UserDaoImpl userDaoImpl = new UserDaoImpl();

    public User getUser(String userCode) {
        return userDaoImpl.getUser(userCode);
    }
}
