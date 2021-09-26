package com.bao.mapper.impl;

import com.bao.mapper.UserMapper;
import com.bao.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public List<User> selectAllUser() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectAllUser();
        return users;
    }
}
