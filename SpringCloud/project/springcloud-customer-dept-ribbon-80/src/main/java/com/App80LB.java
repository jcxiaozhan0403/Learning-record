package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author John.Cena
 * @date 2023/3/18 20:19
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
public class App80LB {
    public static void main(String[] args) {
        SpringApplication.run(App80LB.class,args);
    }
}
