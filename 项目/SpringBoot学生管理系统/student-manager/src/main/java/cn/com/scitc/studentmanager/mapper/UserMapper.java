package cn.com.scitc.studentmanager.mapper;

import cn.com.scitc.studentmanager.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User selectUserByUsername(String username);
}
