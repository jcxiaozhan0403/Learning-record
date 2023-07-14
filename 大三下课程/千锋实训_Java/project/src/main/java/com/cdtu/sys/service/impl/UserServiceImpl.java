package com.cdtu.sys.service.impl;

import com.cdtu.sys.domain.Role;
import com.cdtu.sys.domain.RoleVo;
import com.cdtu.sys.domain.User;
import com.cdtu.sys.domain.UserVo;
import com.cdtu.sys.mapper.RoleMapper;
import com.cdtu.sys.mapper.UserMapper;
import com.cdtu.sys.service.IUserService;
import com.cdtu.sys.utils.DataGridView;
import com.cdtu.sys.utils.SysConstant;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 用户登录的核心方法
     * @param userVo
     * @return
     */
    @Override
    public User login(UserVo userVo) {
        //根据用户名和密码查询
        //先userVo中用户输入的密码进行md5加密操作
        String pwd = DigestUtils.md5DigestAsHex(userVo.getPwd().getBytes());
        userVo.setPwd(pwd);
        //调用userMapper接口中的查询方法
        return userMapper.login(userVo);
    }

    @Override
    public DataGridView queryAllUser(UserVo userVo) {
        Page<Object> page = PageHelper.startPage(userVo.getPage(), userVo.getLimit());
        List<User> list = userMapper.queryAllUser(userVo);
        return new DataGridView(page.getTotal(),list);
    }

    @Override
    public void addUser(UserVo userVo) {
        //设置默认的密码
        userVo.setPwd(DigestUtils.md5DigestAsHex(SysConstant.USER_DEFAULT_PWD.getBytes()));
        //设置用户的类型  type=1是管理员  type=2是普通用户
        userVo.setType(SysConstant.USER_TYPE_NORMAL);
        userMapper.insertSelective(userVo);
    }

    @Override
    public void updateUser(UserVo userVo) {
        userMapper.updateByPrimaryKeySelective(userVo);
    }

    @Override
    public void deleteUser(Integer userid) {
        //删除用户
        userMapper.deleteByPrimaryKey(userid);
    }

    @Override
    public void deleteBatchUser(UserVo userVo) {
        Integer[] ids = userVo.getIds();
        for (Integer id : ids){
            deleteUser(id);
        }
    }

    @Override
    public void resetUserPwd(Integer userid) {
        UserVo userVo = new UserVo();
        userVo.setUserid(userid);
        //设置默认的密码,加密操作
        userVo.setPwd(DigestUtils.md5DigestAsHex(SysConstant.USER_DEFAULT_PWD.getBytes()));
        //更新操作
        userMapper.updateByPrimaryKeySelective(userVo);

    }

    /**
     * 加载用户的角色
     * @param userid
     * @return
     */
    @Override
    public DataGridView queryUserRole(Integer userid) {
        //1.查询所有可用的角色
        RoleVo roleVo = new RoleVo();
        roleVo.setAvailable(SysConstant.AVAILABLE_TRUE);
        List<Role> allRoles = roleMapper.queryAllRole(roleVo);
        //2.根据用户的id查询,该用户拥有哪些角色
        List<Role> userRoles = roleMapper.queryRoleByUid(SysConstant.AVAILABLE_TRUE,userid);
        List<Map<String,Object>> data = new ArrayList<>();
        //3.循环遍历进行设置
        for(Role r1 : allRoles){
            Boolean lay_checked = false;
            for(Role r2 : userRoles){
                if(r1.getRoleid() == r2.getRoleid()){
                    lay_checked = true;
                }
            }
            //4.组装数据
            Map<String,Object> map = new HashMap<>();
            map.put("roleid",r1.getRoleid());
            map.put("rolename",r1.getRolename());
            map.put("roledesc",r1.getRoledesc());
            map.put("LAY_CHECKED",lay_checked);
            data.add(map);
        }

        return new DataGridView(data);
    }

    @Override
    public void saveUserRole(UserVo userVo) {
        Integer userid = userVo.getUserid();
        Integer[] roleIds = userVo.getIds();
        //根据用户id删除sys_role_user表中的该用户的数据
        roleMapper.deleteRoleUserByUid(userid);
        //保存是新添加给这个用户的角色
        if(roleIds != null  && roleIds.length >0){
            for (Integer rid : roleIds){
                userMapper.insertUserRole(userid,rid);
            }
        }

    }
}
