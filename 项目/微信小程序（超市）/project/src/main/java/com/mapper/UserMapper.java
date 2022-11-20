package com.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author John.Cena
 * @date 2022/11/19 13:05
 * @Description:
 */
@Repository // 表示持久层
public interface UserMapper extends BaseMapper<User> {

}
