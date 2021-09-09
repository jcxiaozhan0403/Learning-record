package cn.com.scitc.studentmanager.service;


import cn.com.scitc.studentmanager.mapper.UserMapper;
import cn.com.scitc.studentmanager.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public User Sel(int id){
        return userMapper.Sel(id);
    }
}
