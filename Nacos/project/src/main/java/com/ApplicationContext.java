package com;

import com.config.AppConfig;
import com.pojo.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author John.Cena
 * @date 2023/7/18 15:18
 * @Description:
 */

//@SpringBootApplication
public class ApplicationContext {
    public static void main(String[] args) {
//        SpringApplication.run(ApplicationContext.class, args);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // 可以在这里使用从容器中获取的Bean
        User user = (User) context.getBean("myBean");
        user.test();
        context.close();
    }
}
