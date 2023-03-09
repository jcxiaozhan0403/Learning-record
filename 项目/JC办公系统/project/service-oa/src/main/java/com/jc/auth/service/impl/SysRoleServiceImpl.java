package com.jc.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jc.auth.mapper.SysRoleMapper;
import com.jc.model.system.SysRole;
import com.jc.auth.service.SysRoleService;
import org.springframework.stereotype.Service;

/**
 * @author John.Cena
 * @date 2023/3/9 20:21
 * @Description:
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
}
