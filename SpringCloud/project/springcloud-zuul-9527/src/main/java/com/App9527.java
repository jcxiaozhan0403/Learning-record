package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author John.Cena
 * @date 2023/3/21 20:04
 * @Description:
 */
@SpringBootApplication
@EnableZuulProxy
public class App9527 {
    public static void main(String[] args) {
        SpringApplication.run(App9527.class,args);
    }
}
