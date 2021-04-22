package cn.com.scitc.mybatis.dao;

import cn.com.scitc.mybatis.mapper.UserMapper;
import cn.com.scitc.mybatis.pojo.User;
import cn.com.scitc.mybatis.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

public class UserDao implements UserMapper{

    public User findById(Integer id) {
        //获取SqlSession
        try(SqlSession session = MybatisUtil.getSqlSession()){
            //获取Mapper，执行其中方法
            UserMapper mapper = session.getMapper(UserMapper.class);
            return mapper.findById(id);
        }
    }
}