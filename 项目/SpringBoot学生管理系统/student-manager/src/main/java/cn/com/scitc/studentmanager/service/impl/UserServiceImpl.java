package cn.com.scitc.studentmanager.service.impl;


import cn.com.scitc.studentmanager.common.ResultData;
import cn.com.scitc.studentmanager.mapper.UserMapper;
import cn.com.scitc.studentmanager.pojo.User;
import cn.com.scitc.studentmanager.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author John.Cena
 * @date 2021/10/15 11:35
 * @Description: 用户服务实现类
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    User user;

    @Override
    public User selectUserByToken(String token) {
        return userMapper.selectUserByToken(token);
    }

    /**
     *
     * @param username
     * @param password
     * @return
     * 登录验证
     */
    public boolean validate(String username,String password) {
        try {
            String passwordInDB = userMapper.findPassWordByUsername(username);
            if (password.equals(passwordInDB)) {
                return true;
            }else {
                return false;
            }
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public void createToken(String token,int user_id) {
        userMapper.createToken(token,user_id);
    }

    @Override
    public int findIdByUsername(String username) {
        int id = userMapper.findIdByUsername(username);
        return id;
    }

    @Override
    public void cleanToken() {
        userMapper.cleanToken();
    }

    @Override
    public void updateUserInfo(User user) {
        userMapper.updateUserInfo(user);
    }

    @Override
    public ResultData updatePassword(JSONObject jsonObject) {
        int id = jsonObject.getIntValue("id");
        user = userMapper.findById(id);
        if (user.getPassword().equals(jsonObject.getString("oldP"))) {
            // 修改密码操作
            user.setPassword(jsonObject.getString("newP"));
            userMapper.updateUserPassword(user);
            return ResultData.ok().message("修改成功");
        }else {
            return ResultData.error().message("修改失败");
        }
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }
}
