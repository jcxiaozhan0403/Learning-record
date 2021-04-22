package cn.com.scitc.mybatis.mapper;

import cn.com.scitc.mybatis.pojo.User;

public interface UserMapper {
    public User findById(Integer id);
}