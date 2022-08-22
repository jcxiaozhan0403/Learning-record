package com.cheng.service;

import com.cheng.pojo.Role;
import com.cheng.pojo.User;

import java.util.List;

public interface UserService {
    User getUser(String userCode);

    int updatePwd(String userCode,String password);

    int getUserCount(String userName,int userRole);

    List<User> getUserList(String queryUserName, int queryUserRole,int currentPageNo,int pageSize);

    List<Role> getRoleList();

    int addUser(User user);

    int deleteUserById(Integer id);

    int modify(User user);
}
