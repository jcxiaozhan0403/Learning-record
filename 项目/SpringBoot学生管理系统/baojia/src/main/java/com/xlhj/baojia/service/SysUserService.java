package com.xlhj.baojia.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xlhj.baojia.entity.SysUser;
import com.xlhj.baojia.vo.LoginBody;

/**
 * @ClassName SysUserService
 * @Description 用户管理业务层接口
 * @Author liucaijing
 * @Date 2020/10/20 22:02
 * @Version 1.0
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 校验登录用户
     * @param loginBody
     * @return
     */
    SysUser validateUser(LoginBody loginBody);

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    SysUser selectUserByUsername(String username);

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    SysUser selectUserByUserName(String username);

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return
     */
    //String login(String username, String password);

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    //SysUser selectUserByUserName(String username);
}
