package com.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author John.Cena
 * @date 2022/9/10 11:31
 * @Description:
 */
@SpringBootTest
class PersonTest {
    @Autowired
    Person person;

    @Test
    void getName() {
        System.out.println(person);
    }
}