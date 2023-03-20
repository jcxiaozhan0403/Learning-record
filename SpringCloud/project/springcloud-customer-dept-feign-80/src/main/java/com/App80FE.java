package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author John.Cena
 * @date 2023/3/18 20:19
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.jc.service"})
public class App80FE {
    public static void main(String[] args) {
        SpringApplication.run(App80FE.class,args);
    }
}
