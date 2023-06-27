package com.cdtu.sys.mapper;

import com.cdtu.sys.domain.User;
import com.cdtu.sys.domain.UserVo;

/**
 * @Author:千锋强哥
 * @organization: 千锋教研院
 * @Version: 1.0
 */
public interface UserMapper {

    User findUserByNameAndPwd(UserVo userVo);
}
