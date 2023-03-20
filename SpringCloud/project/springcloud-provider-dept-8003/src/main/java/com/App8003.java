package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author John.Cena
 * @date 2023/3/18 16:42
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
public class App8003 {
    public static void main(String[] args) {
        SpringApplication.run(App8003.class,args);
    }
}
