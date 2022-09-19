package com;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author John.Cena
 * @date 2022/9/19 15:08
 * @Description:
 */

@SpringBootTest
public class MyTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void text() {
        String sql = "select * from user";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        System.out.println(maps);
    }
}
