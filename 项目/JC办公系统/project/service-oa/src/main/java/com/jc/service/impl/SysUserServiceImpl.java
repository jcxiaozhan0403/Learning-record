package com.jc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jc.mapper.SysUserMapper;
import com.jc.model.system.SysRole;
import com.jc.model.system.SysUser;
import com.jc.model.system.SysUserRole;
import com.jc.service.SysMenuService;
import com.jc.service.SysRoleService;
import com.jc.service.SysUserRoleService;
import com.jc.service.SysUserService;
import com.jc.vo.system.RouterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author John.Cena
 * @date 2023/4/4 17:37
 * @Description:
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Autowired
    SysMenuService sysMenuService;
    @Autowired
    SysRoleService sysRoleService;
    @Autowired
    SysUserRoleService sysUserRoleService;

    /**
     * 更新用户状态
     * @param id
     * @param status
     */
    @Transactional
    @Override
    public void updateStatus(Long id, Integer status) {
        SysUser sysUser = this.getById(id);
        if(status.intValue() == 1) {
            sysUser.setStatus(status);
        } else {
            sysUser.setStatus(0);
        }
        this.updateById(sysUser);
    }

    @Override
    public SysUser getByUsername(String username) {

        return super.getOne(new LambdaQueryWrapper<SysUser>().eq(SysUser::getUsername, username));
    }

    @Override
    public Map<String, Object> getUserInfo(Long userId, String userName) {
        Map<String, Object> map = new HashMap<>();
        //3.使用用户id查询用户信息
        SysUser userInfo = this.getByUsername(userName);
        //4.使用用户id查询角色集
        List<String> roles = getRoles(userId);
        //5.根据用户id查询菜单列表
        List<RouterVo> routerVoList = sysMenuService.findUserMenuList(userId);
        //6.根据用户id查询按钮列表
        List<String> permsList = sysMenuService.findUserPermsList(userId);

        map.put("roles",roles.toString());
        map.put("name",userInfo.getName());
        map.put("avatar",userInfo.getHeadUrl());
        map.put("routers",routerVoList);
        map.put("buttons",permsList);
        return map;
    }

    public List<String> getRoles(Long userId){
        //角色id集
        ArrayList<Integer> integers = new ArrayList<>();
        //角色集
        ArrayList<String> roles = new ArrayList<>();

        //使用用户id查询对应的角色id
        List<SysUserRole> list = sysUserRoleService.list(new LambdaQueryWrapper<SysUserRole>().eq(SysUserRole::getUserId, userId).select(SysUserRole::getRoleId));
        for (SysUserRole sysUserRole : list) {
            integers.add(sysUserRole.getRoleId().intValue());
        }

        //使用角色id查询role_code
        List<SysRole> list1 = sysRoleService.list(new LambdaQueryWrapper<SysRole>().in(SysRole::getId,integers).select(SysRole::getRoleCode));
        for (SysRole sysRole : list1) {
            roles.add(sysRole.getRoleCode());
        }

        return roles;
    }
}
