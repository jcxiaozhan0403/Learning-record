package com.xlhj.baojia.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xlhj.baojia.entity.SysRole;

import java.util.Set;

/**
 * @ClassName SysRoleService
 * @Description 角色管理业务层接口
 * @Author liucaijing
 * @Date 2020/10/20 22:03
 * @Version 1.0
 */
public interface SysRoleService extends IService<SysRole> {

    /**
     * 根据用户ID查询角色
     * @param userId
     * @return
     */
    Set<String> selectRoleCodeByUserId(Long userId);
}
