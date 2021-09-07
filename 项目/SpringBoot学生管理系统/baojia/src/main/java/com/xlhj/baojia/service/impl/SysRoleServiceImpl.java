package com.xlhj.baojia.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xlhj.baojia.entity.SysRole;
import com.xlhj.baojia.mapper.SysRoleMapper;
import com.xlhj.baojia.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName SysRoleServiceImpl
 * @Description 角色管理业务层接口实现类
 * @Author liucaijing
 * @Date 2020/10/20 22:05
 * @Version 1.0
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Autowired
    private SysRoleMapper roleMapper;

    /**
     * 根据用户ID查询角色
     * @param userId
     * @return
     */
    @Override
    public Set<String> selectRoleCodeByUserId(Long userId) {
        List<SysRole> roleList = roleMapper.selectRoleCodeByUserId(userId);
        Set<String> roleSet = new HashSet<>();
        if (roleList != null) {
            for (SysRole role : roleList) {
                roleSet.addAll(Arrays.asList(role.getRoleCode().trim().split(",")));
            }
        }
        return roleSet;
    }
}
