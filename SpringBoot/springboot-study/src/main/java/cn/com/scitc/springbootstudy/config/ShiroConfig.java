package cn.com.scitc.springbootstudy.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author John.Cena
 * @date 2021/10/22 19:07
 * @Description: Shiro配置
 */
//@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager);

        //页面权限设置
        //1、必须登录才能访问 /main
        //2、当前用户必须拥有 manage 权限才能访问 /manage
        //3、当前用户必须拥有 admin 角色才能访问 /administrator
        Map<String,String> map = new HashMap<>();
        map.put("/main","authc");
        map.put("/manager","perms[manager]");
        map.put("/administrator","roles[admin]");
        factoryBean.setFilterChainDefinitionMap(map);

        factoryBean.setLoginUrl("/toLogin");


        factoryBean.setUnauthorizedUrl("/unauth");
        return factoryBean;
    }


    @Bean
    public DefaultWebSecurityManager securityManager(@Qualifier("myRealm") MyRealm myRealm){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(myRealm);
        return manager;
    }

    @Bean
    public MyRealm myRealm(){
        return new MyRealm();
    }
}
