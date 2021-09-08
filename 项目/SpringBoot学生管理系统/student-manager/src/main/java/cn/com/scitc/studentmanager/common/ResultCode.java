package cn.com.scitc.studentmanager.common;

/**
 *
 * 统一状态码
 *
 */
public interface ResultCode {

    /**成功*/
    public static Integer SUCCESS = 20000;
    /**失败*/
    public static Integer ERROR = 20001;
    /**未授权*/
    public static Integer UNAUTHORIZED = 401;
}
