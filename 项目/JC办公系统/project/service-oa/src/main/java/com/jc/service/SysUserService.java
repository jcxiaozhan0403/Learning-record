package com.jc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jc.model.system.SysUser;

import java.util.Map;

/**
 * @author John.Cena
 * @Description:
 */
public interface SysUserService extends IService<SysUser> {
    /**
     * 更新用户状态
     * @param id
     * @param status
     */
    void updateStatus(Long id, Integer status);

    SysUser getByUsername(String username);

    /**
     * 根据用户名获取用户登录信息
     * @param userName
     * @return
     */
    Map<String, Object> getUserInfo(Long userId,String userName);

    Map<String, Object> getCurrentUser();
}
