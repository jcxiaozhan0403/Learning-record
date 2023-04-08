package com.jc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jc.model.system.SysMenu;
import com.jc.vo.system.AssignMenuVo;
import com.jc.vo.system.RouterVo;

import java.util.List;

/**
 * @author John.Cena
 * @date 2023/4/5 11:24
 * @Description:
 */
public interface SysMenuService extends IService<SysMenu> {

    /**
     * 菜单树形数据
     * @return
     */
    List<SysMenu> findNodes();

    /**
     * 根据角色id获取菜单集
     * @return
     */
    List<SysMenu> findSysMenuByRoleId(Long roleId);

    /**
     * 保存角色权限
     * @param  assignMenuVo
     */
    void doAssign(AssignMenuVo assignMenuVo);

    /**
     * 获取用户菜单
     * @param userId
     * @return
     */
    List<RouterVo> findUserMenuList(Long userId);

    /**
     * 获取用户按钮权限
     * @param userId
     * @return
     */
    List<String> findUserPermsList(Long userId);

}
