package com.cdtu.sys.service;

import com.cdtu.sys.domain.User;
import com.cdtu.sys.domain.UserVo;

/**
 * @Author:千锋强哥
 * @organization: 千锋教研院
 * @Version: 1.0
 */
public interface IUserService {

    User login(UserVo userVo);
}
