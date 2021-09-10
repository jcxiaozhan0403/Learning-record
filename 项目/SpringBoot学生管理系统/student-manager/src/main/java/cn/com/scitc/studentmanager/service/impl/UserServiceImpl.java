package cn.com.scitc.studentmanager.service.impl;


import cn.com.scitc.studentmanager.mapper.UserMapper;
import cn.com.scitc.studentmanager.pojo.User;
import cn.com.scitc.studentmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    // 根据token查询用户信息，用于登录
    @Override
    public User selectUserByToken(String token) {
        return userMapper.selectUserByToken(token);
    }

//    @Override
//    public String findPassWordByUsername(String username, String password) {
//        return null;
//    }

    // 验证登录
    public boolean validate(String username,String password) {
        try {
            String passwordInDB = userMapper.findPassWordByUsername(username,password);
            if (password.equals(passwordInDB)) {
                return true;
            }else {
                return false;
            }
        }catch (Exception e) {
            return false;
        }
    }

    // 验证通过更新token
    @Override
    public void createToken(String token,int user_id) {
        userMapper.createToken(token,user_id);
    }

    // 根据用户名查询id
    @Override
    public int findIdByUsername(String username) {
        int id = userMapper.findIdByUsername(username);
        return id;
    }

    // 清空token表
    @Override
    public void cleanToken() {
        userMapper.cleanToken();
    }
}
