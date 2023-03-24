package com.example.project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
class ProjectApplicationTests {
    //这里使用Autowire注入会报错，所以使用Resource进行注入
    //Resource是根据先根据bean的名字进行自动装配，如果找不到再根据类型进行装配
    @Resource
    private RedisTemplate redisTemplate;

    //StringRedisTemplate是专门用于存储 <String,String> 类型数据的模板
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("name","zhangsan");
        System.out.println(redisTemplate.opsForValue().get("name"));
    }

    @Test
    void test1(){
        stringRedisTemplate.opsForValue().set("demo","lisi");
        System.out.println(redisTemplate.opsForValue().get("demo"));
    }
}
