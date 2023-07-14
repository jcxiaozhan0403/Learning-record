package com.cdtu.sys.mapper;

import com.cdtu.sys.domain.User;
import com.cdtu.sys.domain.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    User login(UserVo userVo);

    List<User> queryAllUser(UserVo userVo);

    void insertSelective(UserVo userVo);

    void updateByPrimaryKeySelective(UserVo userVo);

    void deleteByPrimaryKey(Integer userid);

    void insertUserRole(@Param("uid") Integer userid, @Param("rid") Integer rid);
}
