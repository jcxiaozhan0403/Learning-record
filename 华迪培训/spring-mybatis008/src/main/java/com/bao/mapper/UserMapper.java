package com.bao.mapper;

import com.bao.pojo.User;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface UserMapper {
    List<User> selectAllUser();
}
