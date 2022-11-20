package com.service;

import com.mapper.UserMapper;
import com.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author John.Cena
 * @date 2022/11/20 9:59
 * @Description:
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

}
