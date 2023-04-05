package com.jc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jc.model.system.SysUser;

/**
 * @author John.Cena
 * @date 2023/4/4 17:36
 * @Description:
 */
public interface SysUserService extends IService<SysUser> {
    /**
     * 更新用户状态
     * @param id
     * @param status
     */
    void updateStatus(Long id, Integer status);
}
