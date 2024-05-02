package com.jc.common.jwt;

import io.jsonwebtoken.*;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * JWT工具类
 * @author John.Cena
 * @date 2023/4/6 13:59
 * @Description:
 */
public class JwtHelper {

//    private static long tokenExpiration = 2 * 60 * 60 * 1000;
    private static long tokenExpiration = 365 * 24 * 60 * 60 * 1000;
    private static String tokenSignKey = "123456";

    public static String createToken(Long userId, String username) {
        String token = Jwts.builder()
                .setSubject("AUTH-USER")
                //过期时间
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))
                //有效载荷
                .claim("userId", userId)
                .claim("username", username)
                //签名信息
                .signWith(SignatureAlgorithm.HS512, tokenSignKey)
                //压缩格式
                .compressWith(CompressionCodecs.GZIP)
                .compact();
        return token;
    }

    public static Long getUserId(String token) {
        try {
            if (StringUtils.isEmpty(token)){
                return null;
            }

            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token);
            Claims claims = claimsJws.getBody();
            Integer userId = (Integer) claims.get("userId");
            return userId.longValue();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getUsername(String token) {
        try {
            if (StringUtils.isEmpty(token)){
                return null;
            }

            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token);
            Claims claims = claimsJws.getBody();
            return (String) claims.get("username");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) {
//        String token = JwtHelper.createToken(1L,"Admin");
//        String token = JwtHelper.createToken(3L,"WangWu");
//        String token = JwtHelper.createToken(7L,"ZhangSan");
//        String token = JwtHelper.createToken(4L,"LiSi");
        String token = JwtHelper.createToken(2L,"ZhaoLiu");
        System.out.println(token);
        System.out.println(JwtHelper.getUserId(token));
        System.out.println(JwtHelper.getUsername(token));
    }
}
