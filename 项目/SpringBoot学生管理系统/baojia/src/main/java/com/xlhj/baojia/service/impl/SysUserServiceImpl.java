package com.xlhj.baojia.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xlhj.baojia.entity.SysUser;
import com.xlhj.baojia.mapper.SysUserMapper;
import com.xlhj.baojia.service.SysUserService;
import com.xlhj.baojia.vo.LoginBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName SysUserServiceImpl
 * @Description 用户管理业务层接口实现类
 * @Author liucaijing
 * @Date 2020/10/20 22:04
 * @Version 1.0
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper userMapper;

    /**
     * 验证登录信息
     * @param loginBody
     * @return
     */
    @Override
    public SysUser validateUser(LoginBody loginBody) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", loginBody.getUsername());
        wrapper.eq("password", loginBody.getPassword());
        SysUser currentUser = userMapper.selectOne(wrapper);
        return currentUser;
    }

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    @Override
    public SysUser selectUserByUsername(String username) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", username);
        SysUser user = userMapper.selectOne(wrapper);
        return user;
    }

    @Override
    public SysUser selectUserByUserName(String username) {
        return null;
    }

}
