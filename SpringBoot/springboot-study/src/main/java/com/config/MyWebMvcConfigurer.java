package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

/**
 * @author John.Cena
 * @date 2022/9/16 18:25
 * @Description:
 */
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {
    @Bean //放到bean中
    public ViewResolver myViewResolver(){
        return new MyViewResolver();
    }

    //我们写一个静态内部类，视图解析器就需要实现ViewResolver接口
    private static class MyViewResolver implements ViewResolver{
        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }
}
