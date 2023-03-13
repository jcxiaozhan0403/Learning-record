package com.bao.mapper.impl;

import com.bao.mapper.UserMapper;
import com.bao.pojo.Student;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public List<Student> selectAllUser() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Student> students = mapper.selectAllUser();
        return students;
    }
}
