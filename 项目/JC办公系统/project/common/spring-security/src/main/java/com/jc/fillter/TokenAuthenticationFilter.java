package com.jc.fillter;

import com.alibaba.fastjson.JSON;
import com.jc.common.jwt.JwtHelper;
import com.jc.common.result.Result;
import com.jc.common.result.ResultCodeEnum;
import com.jc.common.utils.ResponseUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 第一层：身份验证过滤器
 * @author John.Cena
 * @date 2023/4/8 22:59
 * @Description:
 */
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private RedisTemplate redisTemplate;

    public TokenAuthenticationFilter(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        logger.info("uri:"+request.getRequestURI());
        //如果是登录接口，直接放行
        if("/admin/system/index/login".equals(request.getRequestURI())) {
            chain.doFilter(request, response);
            return;
        }

        //将用户信息封装在Authentication对象类，具体是通过UsernamePasswordAuthenticationToken来实现的
        UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
        if(authentication != null) {
            //将用户信息存放在Security的上下文中，以便后续使用
            SecurityContextHolder.getContext().setAuthentication(authentication);
            chain.doFilter(request, response);
        } else {
            //用户信息如果为空，则判定为非法操作，返回异常
            ResponseUtil.out(response, Result.build(null, ResultCodeEnum.PERMISSION));
        }
    }

    //封装用户信息
    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        //拿到请求头中的token值，并打印
        String token = request.getHeader("token");
        logger.info("token:"+token);

        //判断token是否为空
        if (!StringUtils.isEmpty(token)) {
            String username = JwtHelper.getUsername(token);
            logger.info("username:"+username);
            //从token中拿到username，判断是否为空
            if (!StringUtils.isEmpty(username)) {
                //从redis中拿到当前用户的权限集字符串
                String authoritiesString = (String) redisTemplate.opsForValue().get(username);
                List<Map> mapList = JSON.parseArray(authoritiesString, Map.class);
                List<SimpleGrantedAuthority> authorities = new ArrayList<>();
                for (Map map : mapList) {
                    authorities.add(new SimpleGrantedAuthority((String)map.get("authority")));
                }
                //将用户信息以及用户权限，封装返回
                return new UsernamePasswordAuthenticationToken(username, null, authorities);
            } else {
                return new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());
            }
        }
        return null;
    }
}
