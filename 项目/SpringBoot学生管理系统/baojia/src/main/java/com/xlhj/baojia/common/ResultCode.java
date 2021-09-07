package com.xlhj.baojia.common;

/**
 * @ClassName ResultCode
 * @Description 统一返回状态码
 * @Author liucaijing
 * @Date 2020/10/20 22:31
 * @Version 1.0
 */
public interface ResultCode {

    /**成功*/
    public static Integer SUCCESS = 20000;
    /**失败*/
    public static Integer ERROR = 20001;
    /**未授权*/
    public static Integer UNAUTHORIZED = 401;
}
