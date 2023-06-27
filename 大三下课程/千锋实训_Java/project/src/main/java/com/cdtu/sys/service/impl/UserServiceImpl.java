package com.cdtu.sys.service.impl;


import com.cdtu.sys.domain.User;
import com.cdtu.sys.domain.UserVo;
import com.cdtu.sys.mapper.UserMapper;
import com.cdtu.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * @Author:千锋强哥
 * @organization: 千锋教研院
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户登录的方法
     * @param userVo  里面是用户名和密码
     * @return 数据库根据用户名和密码查询到的一个user对象
     */
    @Override
    public User login(UserVo userVo) {
        //1.获取到前台的密码，进行md5加密
        String pwd = userVo.getPwd();
        String digestPwd = DigestUtils.md5DigestAsHex(pwd.getBytes());

        //2.重新给userVo设置加密后的密码
        userVo.setPwd(digestPwd);

        //3.调用userMapper中的查询方法，返回一个user对象
        User user = userMapper.findUserByNameAndPwd(userVo);
        return user;
    }
}
