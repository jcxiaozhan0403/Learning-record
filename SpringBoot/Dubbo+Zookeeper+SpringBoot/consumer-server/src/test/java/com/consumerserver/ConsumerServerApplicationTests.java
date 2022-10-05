package com.consumerserver;

import com.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConsumerServerApplicationTests {
    @Autowired
    UserServiceImpl userServiceImpl;

    @Test
    void contextLoads() {
        System.out.println(userServiceImpl.bugTicket());
    }

}
