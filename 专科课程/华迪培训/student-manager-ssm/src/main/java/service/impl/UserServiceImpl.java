package service.impl;

import mapper.UserMapper;
import pojo.User;
import service.UserService;

public class UserServiceImpl implements UserService {

    //调用dao层的操作，设置一个set接口，方便Spring管理
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User findInfoByUsername(String username) {
        return userMapper.findInfoByUsername(username);
    }
}
