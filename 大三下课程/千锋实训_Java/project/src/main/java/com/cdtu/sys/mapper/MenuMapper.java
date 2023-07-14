package com.cdtu.sys.mapper;

import com.cdtu.sys.domain.Menu;
import com.cdtu.sys.domain.MenuVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper {
    List<Menu> queryAllMenu(MenuVo menuVo);

    void insertSelective(MenuVo menuVo);

    void updateByPrimaryKeySelective(MenuVo menuVo);

    Integer queryMenuByPid(Integer pid);

    void deleteByPrimaryKey(Integer id);

    List<Menu> queryMenuByRoleId(@Param("available") Integer availableTrue, @Param("rid")Integer roleid);
}
