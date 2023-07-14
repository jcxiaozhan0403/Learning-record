package com.cdtu.sys.service.impl;

import com.cdtu.sys.domain.*;
import com.cdtu.sys.mapper.MenuMapper;
import com.cdtu.sys.mapper.RoleMapper;
import com.cdtu.sys.service.IRoleService;
import com.cdtu.sys.utils.DataGridView;
import com.cdtu.sys.utils.SysConstant;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public DataGridView queryAllRole(RoleVo roleVo) {
        //分页查询
        Page<Object> page = PageHelper.startPage(roleVo.getPage(), roleVo.getLimit());
        List<Role> list = roleMapper.queryAllRole(roleVo);
        return new DataGridView(page.getTotal(),list);
    }

    @Override
    public void addRole(RoleVo roleVo) {
        roleMapper.insertSelective(roleVo);
    }

    @Override
    public void updateRole(RoleVo roleVo) {
        roleMapper.updateByPrimarySelective(roleVo);
    }

    @Override
    public void deleteRole(Integer roleid) {
        roleMapper.deleteByPrimaryKey(roleid);
    }

    @Override
    public void deleteBatchRole(Integer[] ids) {
        for (Integer rid : ids){
            deleteRole(rid);
        }
    }

    @Override
    public DataGridView initRoleMenuTreeJson(Integer roleid) {
        //查询所有的可用菜单
        MenuVo menuvo = new MenuVo();
        menuvo.setAvailable(SysConstant.AVAILABLE_TRUE);
        List<Menu> allMenu = menuMapper.queryAllMenu(menuvo);

        //根据角色ID查询当前角色拥有的菜单
        List<Menu> roleMenu = menuMapper.queryMenuByRoleId(SysConstant.AVAILABLE_TRUE,roleid);

        //创建LIst<TreeNode>
        List<TreeNode> data = new ArrayList<>();
        for(Menu m1 : allMenu){
            String checkArr = SysConstant.CODE_ZERO+"";
            for(Menu m2 : roleMenu){
                if(m1.getId() == m2.getId()){
                    checkArr = SysConstant.CODE_ONE+"";
                    break;
                }
            }
            Integer id = m1.getId();
            Integer pid = m1.getPid();
            String title = m1.getTitle();
            Boolean spread = m1.getSpread() == SysConstant.SPREAD_TRUE? true:false;
            data.add(new TreeNode(id,pid,title,spread,checkArr));
        }
        return new DataGridView(data);
    }

    @Override
    public void saveRoleMenu(RoleVo roleVo) {
        //角色id
        Integer rid = roleVo.getRoleid();
        //菜单id
        Integer[] mids = roleVo.getIds();
        //根据rid删除sys_role_menu 里面的所有数据
        roleMapper.deleteRoleMenuByRid(rid);
        //重新保存角色和菜单的关系
        for(Integer mid : mids){
            roleMapper.insertRoleMenu(rid,mid);
        }
    }
}
