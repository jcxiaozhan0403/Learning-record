package com.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author John.Cena
 * @date 2022/9/24 17:31
 * @Description:
 */
@EnableWebSecurity // 开启WebSecurity模式
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // 定制请求的授权规则
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 链式编程
        http.authorizeRequests()
            // 首页所有人可以访问
            .antMatchers("/").permitAll()
            // 拥有vip1权限的用户可以访问如下url的页面
            .antMatchers("/main/**").hasRole("vip");

        // 开启登录功能
        // 默认/login请求来到登录页，login?error 重定向到这里表示登录失败
        http.formLogin();

        //关闭csrf功能:跨站请求伪造,默认只能通过post方式提交logout请求
        http.csrf().disable();
        //开启注销功能
        // 默认/logout为注销请求
        http.logout()
            //注销成功跳转url
            .logoutSuccessUrl("/");

        // 开启记住我
        http.rememberMe();

    }

    //定制认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // inMemoryAuthentication在内存中定义，也可以在jdbc中去拿，将inMemoryAuthentication()替换为jdbcAuthentication()即可
        // passwordEncoder定义密码的加密规则，有多种加密方式可选，bcrypt是官方推荐的
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("sss").password(new BCryptPasswordEncoder().encode("123456")).roles("vip");
    }
}
