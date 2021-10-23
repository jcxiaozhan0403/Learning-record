package cn.com.scitc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringbootStudy2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootStudy2Application.class, args);
    }

}
