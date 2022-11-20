package com;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.entity.User;
import com.mapper.GoodsMapper;
import com.entity.Goods;
import com.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProjectApplicationTests {

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        //查询是否为新用户
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.select("openId");
        wrapper.eq("openId","123456");
        User user = userMapper.selectOne(wrapper);
    }

}
