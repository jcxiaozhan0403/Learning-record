package com.springbootdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootDemoApplicationTests {

    @Test
    void contextLoads() {
        String str = null;
        System.out.println(str == null);
    }

}
