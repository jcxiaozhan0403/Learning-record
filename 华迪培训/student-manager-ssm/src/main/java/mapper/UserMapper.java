package mapper;

import pojo.User;

public interface UserMapper {
    // 根据用户名查询用户信息
    User findInfoByUsername(String username);
}
