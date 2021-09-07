package com.xlhj.baojia.util;

import com.xlhj.baojia.entity.SysUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TokenUtils
 * @Description token相关工具类
 * @Author liucaijing
 * @Date 2020/10/20 23:57
 * @Version 1.0
 */
@Data
@Component
public class JwtTokenUtils {

    @Value("${jwt.header}")
    private String header;
    //@Value(("${jwt.tokenPrefix}"))
    //private String tokenPrefix;
    @Value("${jwt.tokenSecret}")
    private String tokenSecret;
    @Value("${jwt.tokenExpired}")
    private Long tokenExpired;
    private String LOGIN_USER_KEY = "login_user_key";
    //private String getTokenPrefix() {
        //return tokenPrefix + " ";
    //}

    private static final long MILLIS_SECOND = 1000;

    private static final long MILLIS_MINUTE = 60 * MILLIS_SECOND;

    private static final Long MILLIS_MINUTE_TEN = 20 * 60 * 1000L;

    public String generateToken(SysUser currentUser) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("sub", currentUser.getUserName());
        claims.put("created", new Date());
        return generateToken(claims);
    }

    private String generateToken(Map<String, Object> claims) {
        Date expirationDate = new Date(System.currentTimeMillis() + tokenExpired);
        return Jwts.builder().setClaims(claims)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, tokenSecret).compact();
    }

    public String getUsernameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(tokenSecret).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    public Boolean isTokenExpired(String token) {
        try {
            Claims claims = getClaimsFromToken(token);
            Date expirtion = claims.getExpiration();
            return expirtion.before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    public String refreshToken(String token) {
        String refreshedToken;
        try {
            Claims claims = getClaimsFromToken(token);
            claims.put("created", new Date());
            refreshedToken = generateToken(claims);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

    public Boolean validateToken(String token, String username) {
        String user = getUsernameFromToken(token);
        return (user.equals(username)) && !isTokenExpired(token);
    }



    /*@Autowired
    private static RedisCacheUtils redisCache;



    *//**
     * 生成token
     * @param loginUser
     * @return
     *//*
    public static String createToken(LoginUser loginUser) {
        String uuid = UUID.fastUUID().toString();
        loginUser.setToken(uuid);
        refreshToken(loginUser);
        Map<String, Object> claims = new HashMap<>();
        claims.put(LOGIN_USER_KEY, uuid);
        String token = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, tokenSecret).compact();
        return token;
    }

    *//**
     * 从请求中获取用户名
     * @param request
     * @return
     *//*
    public String getUsernameFromToken(HttpServletRequest request) {
        String token = request.getHeader(header);
        if (StrUtil.isNotEmpty(token) && token.startsWith(getTokenPrefix())) {
            token = token.replace(getTokenPrefix(), "");
        }
        Claims claims = Jwts.parser().setSigningKey(tokenSecret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    *//**
     * 刷新token
     * @param loginUser
     *//*
    public static void refreshToken(LoginUser loginUser) {
        loginUser.setLoginTime(System.currentTimeMillis());
        loginUser.setExpireTime(loginUser.getLoginTime() + tokenExpired * MILLIS_MINUTE);
        String userKey = LOGIN_USER_KEY + loginUser.getToken();
        redisCache.setCacheObject(userKey, loginUser, tokenExpired, TimeUnit.MINUTES);
    }

    *//**
     * 获取用户身份信息
     * @param request
     * @return
     *//*
    public static LoginUser getLoginUser(HttpServletRequest request) {
        String token = getToken(request);
        if (StrUtil.isNotEmpty(token)) {
            Claims claims = parseToken(token);
            String uuid = (String) claims.get(LOGIN_USER_KEY);
            String userKey = LOGIN_USER_KEY + uuid;
            LoginUser loginUser = redisCache.getCacheObject(userKey);
            return loginUser;
        }
        return null;
    }

    *//**
     * 获取请求的token
     * @param request
     * @return
     *//*
    private static String getToken(HttpServletRequest request) {
        String token = request.getHeader(header);
        if (StrUtil.isNotEmpty(token) && token.startsWith(getTokenPrefix())) {
            token = token.replace(getTokenPrefix(), "");
        }
        return token;
    }

    *//**
     * 解析token
     * @param token
     * @return
     *//*
    private static Claims parseToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(tokenSecret).parseClaimsJws(token).getBody();
        return claims;
    }

    *//**
     * 验证用户信息
     * @param loginUser
     *//*
    public static void verifyToken(LoginUser loginUser) {
        long expireTime = loginUser.getExpireTime();
        long currentTime = System.currentTimeMillis();
        if (expireTime - currentTime <= MILLIS_MINUTE_TEN) {
            refreshToken(loginUser);
        }
    }*/
}
