package com.cdtu.sys.mapper;

import com.cdtu.sys.domain.Role;
import com.cdtu.sys.domain.RoleVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    List<Role> queryAllRole(RoleVo roleVo);

    void insertSelective(RoleVo roleVo);

    void updateByPrimarySelective(RoleVo roleVo);

    void deleteByPrimaryKey(Integer roleid);

    /**
     * 根据觉色id删除中间表sys_role_menu中的数据
     * @param rid
     */
    void deleteRoleMenuByRid(Integer rid);

    /**
     * 保存角色和菜单的关系到sys_role_menu
     * @param rid
     * @param mid
     */
    void insertRoleMenu(@Param("rid") Integer rid, @Param("mid") Integer mid);

    List<Role> queryRoleByUid(@Param("available") Integer availableTrue,@Param("uid")  Integer userid);

    void deleteRoleUserByUid(Integer userid);
}
