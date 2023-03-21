package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author John.Cena
 * @date 2023/3/18 16:42
 * @Description:
 */
@SpringBootApplication
@MapperScan("com.jc.mapper")
@EnableEurekaClient
@EnableHystrix //添加对熔断支持的注解
public class App8001HY {
    public static void main(String[] args) {
        SpringApplication.run(App8001HY.class,args);
    }
}
