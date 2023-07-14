package com.cdtu.sys.controller;

import com.cdtu.sys.domain.Menu;
import com.cdtu.sys.domain.MenuVo;
import com.cdtu.sys.domain.TreeNode;
import com.cdtu.sys.domain.User;
import com.cdtu.sys.service.IMenuService;
import com.cdtu.sys.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("menu")
public class MenuController {

    @Autowired
    private IMenuService menuService;

    //创建加载菜单栏的方法
    @RequestMapping("loadIndexLeftMenuJson")
    public List<TreeNode> loadIndexLeftMenuJson(MenuVo menuVo){
        //得到当前登录用户的对象
        User user = (User) WebUtils.getHttpSession().getAttribute("user");
        menuVo.setAvailable(SysConstant.AVAILABLE_TRUE);

        List<Menu> list = null;
        //判断用户的类型
        if(user.getType() == SysConstant.USER_TYPE_SUPER){
            //如果用户类型是管理员，查询所有的菜单
            list =   menuService.queryAllMenuForList(menuVo);
        }else{
            //@TODO 用户如果不是管理员，展示的菜单也是不同的，添加权限的时候再说

        }

        //声明返回List<TreeNode>对象，给该对象赋值
        List<TreeNode> nodes = new ArrayList<>();
        for(Menu menu : list){
            Integer id =  menu.getId();
            Integer pid = menu.getPid();
            String title = menu.getTitle();
            String icon = menu.getIcon();
            String href = menu.getHref();
            Boolean spread = menu.getSpread() == SysConstant.SPREAD_TRUE ? true : false;
            String target = menu.getTarget();
            nodes.add(new TreeNode(id,pid,title,icon,href,spread,target));
        }
        return TreeNodeBuilder.builder(nodes,1);
    }

    /**
     * 加载菜单管理器左侧数菜单
     */
    @RequestMapping("loadMenuManagerLeftTreeJson")
    public DataGridView loadMenuManagerLeftTreeJson(MenuVo menuVo){
        menuVo.setAvailable(SysConstant.AVAILABLE_TRUE);
        List<Menu> list = menuService.queryAllMenuForList(menuVo);

        List<TreeNode> nodes = new ArrayList<>();
        for(Menu menu : list){
            Integer id =  menu.getId();
            Integer pid = menu.getPid();
            String title = menu.getTitle();
            String icon = menu.getIcon();
            String href = menu.getHref();
            Boolean spread = menu.getSpread() == SysConstant.SPREAD_TRUE ? true : false;
            String target = menu.getTarget();
            nodes.add(new TreeNode(id,pid,title,icon,href,spread,target));
        }
        return  new DataGridView(nodes);

    }

    /**
     * 加载菜单列表
     */
    @RequestMapping("loadAllMenu")
    public DataGridView loadAllMenu(MenuVo menuVo){
        return menuService.queryAllMenu(menuVo);
    }

    /**
     * 添加菜单
     */
    @RequestMapping("addMenu")
    public ResultObj addMenu(MenuVo menuVo){
        try {
            menuService.addMenu(menuVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 修改菜单
     */
    @RequestMapping("updateMenu")
    public ResultObj updateMenu(MenuVo menuVo){
        try {
            menuService.updateMenu(menuVo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    /**
     * 根据id判断当前菜单有没有子菜单
     * 返回值大与0
     */
    @RequestMapping("checkMenuHasChildren")
    public ResultObj checkMenuHasChildren(MenuVo menuVo){
        Integer count = menuService.queryMenuByPid(menuVo.getId());
        if(count>0){
            return ResultObj.STATUS_TRUE;
        }else{
            return ResultObj.STATUS_FALSE;
        }
    }

    /**
     * 删除菜单的方法
     */
    @RequestMapping("deleteMenu")
    public ResultObj deleteMenu(MenuVo menuVo){
        try {
            menuService.deleteMenu(menuVo);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
}
