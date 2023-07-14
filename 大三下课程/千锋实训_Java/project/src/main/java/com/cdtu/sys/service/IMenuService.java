package com.cdtu.sys.service;

import com.cdtu.sys.domain.Menu;
import com.cdtu.sys.domain.MenuVo;
import com.cdtu.sys.utils.DataGridView;

import java.util.List;

public interface IMenuService {
    List<Menu> queryAllMenuForList(MenuVo menuVo);

    DataGridView queryAllMenu(MenuVo menuVo);

    void addMenu(MenuVo menuVo);

    void updateMenu(MenuVo menuVo);

    Integer queryMenuByPid(Integer id);

    void deleteMenu(MenuVo menuVo);
}
