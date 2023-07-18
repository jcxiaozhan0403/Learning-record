package com.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author John.Cena
 * @date 2023/7/18 16:38
 * @Description:
 */
@Component
public class User {
    @Value("${name}")
    private String name;

    @Value("${age}")
    private int age;

    public void test(){
        System.out.println(this.name + " " + this.age);
    }
}
