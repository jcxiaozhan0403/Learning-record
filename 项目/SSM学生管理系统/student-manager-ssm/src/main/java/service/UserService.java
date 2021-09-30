package service;

import pojo.User;

public interface UserService {
    // 根据用户名查询用户信息
    User findInfoByUsername(String username);
}
