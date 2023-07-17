package com.jc.config;

import com.jc.custom.CustomMd5PasswordEncoder;
import com.jc.fillter.TokenAuthenticationFilter;
import com.jc.fillter.TokenLoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author John.Cena
 * @date 2023/4/8 23:05
 * @Description:
 */
@Configuration
@EnableWebSecurity //开启SpringSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) //开启注解功能，默认禁用注解
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private CustomMd5PasswordEncoder customMd5PasswordEncoder;
    @Autowired
    private RedisTemplate redisTemplate;

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //这是配置的关键，决定哪些接口开启防护，哪些接口绕过防护
        http
            //关闭csrf
            .csrf().disable()
            //开启跨域以便前端调用接口
            .cors().and()
            .authorizeRequests()
            //指定某些接口不需要通过验证即可访问。登陆接口肯定是不需要认证的
//            .antMatchers("/static/**").permitAll()
            //这里意思是其它所有接口需要认证才能访问
            .anyRequest().authenticated()
            .and()
            //TokenAuthenticationFilter放到UsernamePasswordAuthenticationFilter的前面，这样做就是为了除了登录的时候去查询数据库外，其他时候都用token进行认证。
            .addFilterBefore(new TokenAuthenticationFilter(redisTemplate), UsernamePasswordAuthenticationFilter.class)
            .addFilter(new TokenLoginFilter(authenticationManager(), redisTemplate));

        //禁用session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 指定UserDetailService和密码校验组件
        // 我们在service-oa模块中新建了 userDetailsServiceImpl 来覆盖他原生的查询过程
        auth.userDetailsService(userDetailsService).passwordEncoder(customMd5PasswordEncoder);
    }

    /**
     * 配置哪些请求不拦截
     * 排除swagger相关请求
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/admin/modeler/**","/diagram-viewer/**","/editor-app/**","/*.html",
                "/admin/processImage/**",
                "/admin/wechat/authorize","/admin/wechat/userInfo","/admin/wechat/bindPhone",
                "/favicon.ico","/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**", "/doc.html",
                "/static/**","/","/index");
    }
}
