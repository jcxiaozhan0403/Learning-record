package com.cdtu.sys.service;

import com.cdtu.sys.domain.RoleVo;
import com.cdtu.sys.utils.DataGridView;

public interface IRoleService {
    DataGridView queryAllRole(RoleVo roleVo);

    void addRole(RoleVo roleVo);

    void updateRole(RoleVo roleVo);

    void deleteRole(Integer roleid);

    void deleteBatchRole(Integer[] ids);

    DataGridView initRoleMenuTreeJson(Integer roleid);

    void saveRoleMenu(RoleVo roleVo);
}
