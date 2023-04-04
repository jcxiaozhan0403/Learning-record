package com.jc.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jc.model.system.SysRole;
import com.jc.vo.system.AssginRoleVo;

import java.util.Map;

/**
 * @author John.Cena
 * @date 2023/3/9 20:20
 * @Description:
 */
public interface SysRoleService extends IService<SysRole> {
    /**
     * 根据用户获取角色数据
     * @param userId
     * @return
     */
    Map<String, Object> findRoleByUserId(Long userId);

    /**
     * 分配角色
     * @param assginRoleVo
     */
    void doAssign(AssginRoleVo assginRoleVo);
}
