package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //这个类是一个SpringBoot入口类,有且仅有一个
public class Application {
    public static void main(String[] args) {
        //参数1：入口类类对象 参数2：main函数参数
        SpringApplication.run(Application.class,args);
    }
}