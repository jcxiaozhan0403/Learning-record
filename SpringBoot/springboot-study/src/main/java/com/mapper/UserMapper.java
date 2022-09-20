package com.mapper;

import com.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author John.Cena
 * @date 2022/9/20 11:33
 * @Description:
 */
@Repository
public interface UserMapper {
    List<User> userList();
}
