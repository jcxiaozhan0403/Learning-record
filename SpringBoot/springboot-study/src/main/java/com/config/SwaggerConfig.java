package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author John.Cena
 * @date 2022/10/5 0:22
 * @Description:
 */
@Configuration
@EnableSwagger2 //开启Swagger2的自动配置
public class SwaggerConfig {

    @Bean
    public Docket docket(Environment environment) {
        // 设置要开启swagger的环境
        Profiles of = Profiles.of("dev","test");
        // 判断当前是否处于该环境
        // 通过 enable() 接收此参数判断是否要显示
        boolean flag = environment.acceptsProfiles(of);

        return new Docket(DocumentationType.SWAGGER_2)
                .enable(flag);
    }
}
