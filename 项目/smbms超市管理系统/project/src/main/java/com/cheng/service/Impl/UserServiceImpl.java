package com.cheng.service.Impl;

import com.cheng.dao.UserMapper;
import com.cheng.pojo.Role;
import com.cheng.pojo.User;
import com.cheng.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(String userCode) {
        return this.userMapper.getUser(userCode);
    }


    @Override
    public int updatePwd(String userCode, String password) {
        return this.userMapper.updatePwd(userCode, password);
    }


    @Override
    public int getUserCount(String userName, int userRole) {
        return this.userMapper.getUserCount(userName, userRole);
    }

    @Override
    public List<User> getUserList(String queryUserName, int queryUserRole,int currentPageNo,int pageSize){
        return this.userMapper.getUserList(queryUserName,queryUserRole,currentPageNo,pageSize);
    }

    @Override
    public List<Role> getRoleList(){
        return this.userMapper.getRoleList();
    }

    @Override
    public int addUser(User user){ return  this.userMapper.addUser(user);}

    @Override
    public int deleteUserById(Integer id){return this.userMapper.deleteUserById(id);};



    @Override
    public int modify(User user){return this.userMapper.modify(user);}
}
