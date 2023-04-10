package com.jc.helper;

import com.jc.model.system.SysMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * 帮助类，用于生成菜单的树状结构
 * @author John.Cena
 * @date 2023/4/5 12:33
 * @Description:
 */
public class MenuHelper {

    /**
     * 递归构建菜单树型结构
     * @param sysMenuList 菜单列表
     * @return
     */
    public static List<SysMenu> buildTree(List<SysMenu> sysMenuList) {
        List<SysMenu> trees = new ArrayList<>();
        //遍历菜单的每一个子项
        for (SysMenu sysMenu : sysMenuList) {
            if (sysMenu.getParentId().longValue() == 0) {
                //如果某子项的父id为0，说明它是根菜单
                //向下查找它的子菜单
                trees.add(findChildren(sysMenu,sysMenuList));
            }
        }
        return trees;
    }


    /**
     * 递归查找子菜单
     * @param sysMenu 当前菜单
     * @param treeNodes 菜单列表
     * @return
     */
    public static SysMenu findChildren(SysMenu sysMenu, List<SysMenu> treeNodes) {
        //新建List集合，作为当前节点的子菜单集
        sysMenu.setChildren(new ArrayList<SysMenu>());

        for (SysMenu it : treeNodes) {
            //遍历菜单列表，如果他们的父id与当前菜单的id相同，则把他们加入子菜单集
            if(sysMenu.getId().longValue() == it.getParentId().longValue()) {
                if (sysMenu.getChildren() == null) {
                    //初始化Children属性
                    sysMenu.setChildren(new ArrayList<>());
                }
                //findChildren(it,treeNodes)递归添加子菜单
                sysMenu.getChildren().add(findChildren(it,treeNodes));
            }
        }
        return sysMenu;
    }
}
