package com.cheng.dao;

import com.cheng.pojo.Role;
import com.cheng.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    //根据用户名获取用户
    User getUser(String userCode);

    int updatePwd(@Param("userCode") String userCode, @Param("password")String password);

    //查询用户总数
//    @Select("select count(1) as count form smbms_user")
    int getUserCount(@Param("userName") String userName , @Param("userRole") int userRole);

    List<User> getUserList(@Param("userName") String userName,@Param("userRole") int userRole,@Param("currentPageNo") int currentPageNo,@Param("pageSize") int pageSize);

    //获取角色列表
    List<Role> getRoleList();

    int addUser(User user);

    int deleteUserById(Integer id);

    int modify(User user);
}
