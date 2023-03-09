package com.jc.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author John.Cena
 * @date 2023/3/9 19:36
 * @Description:
 */
@SpringBootApplication
@MapperScan("com.jc.*.mapper")
public class ServiceAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceAuthApplication.class, args);
    }

}
