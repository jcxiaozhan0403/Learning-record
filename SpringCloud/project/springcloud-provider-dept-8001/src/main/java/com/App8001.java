package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author John.Cena
 * @date 2023/3/18 16:42
 * @Description:
 */
@SpringBootApplication
@MapperScan("com.jc.mapper")
@EnableEurekaClient
public class App8001 {
    public static void main(String[] args) {
        SpringApplication.run(App8001.class,args);
    }
}
