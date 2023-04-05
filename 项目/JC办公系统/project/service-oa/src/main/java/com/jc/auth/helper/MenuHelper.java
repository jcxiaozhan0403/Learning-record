package com.jc.auth.helper;

import com.jc.model.system.SysMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author John.Cena
 * @date 2023/4/5 12:33
 * @Description:
 */
public class MenuHelper {

    /**
     * 使用递归方法建菜单
     * @param sysMenuList
     * @return
     */
    public static List<SysMenu> buildTree(List<SysMenu> sysMenuList) {
        List<SysMenu> trees = new ArrayList<>();
        for (SysMenu sysMenu : sysMenuList) {
            if (sysMenu.getParentId().longValue() == 0) {
                //如果某一列的父ID为0，说明它是根节点
                //将本节点以及所有节点信息传入查找函数做处理
                trees.add(findChildren(sysMenu,sysMenuList));
            }
        }
        return trees;
    }

    /**
     * 递归查找子节点
     * @param treeNodes
     * @return
     */
    public static SysMenu findChildren(SysMenu sysMenu, List<SysMenu> treeNodes) {
        //新建List集合，作为当前节点的子结点集
        sysMenu.setChildren(new ArrayList<SysMenu>());

        for (SysMenu it : treeNodes) {
            //遍历所有列，如果他们的父ID与本节点ID相同，则把他们加入子结点集
            if(sysMenu.getId().longValue() == it.getParentId().longValue()) {
                if (sysMenu.getChildren() == null) {
                    sysMenu.setChildren(new ArrayList<>());
                }
                //节点集中如果还有子节点集，递归遍历
                sysMenu.getChildren().add(findChildren(it,treeNodes));
            }
        }
        return sysMenu;
    }
}
