package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author John.Cena
 * @date 2023/3/19 10:18
 * @Description:
 */
@SpringBootApplication
//开启注册中心
@EnableEurekaServer
public class App7003 {
    public static void main(String[] args) {
        SpringApplication.run(App7003.class,args);
    }
}
