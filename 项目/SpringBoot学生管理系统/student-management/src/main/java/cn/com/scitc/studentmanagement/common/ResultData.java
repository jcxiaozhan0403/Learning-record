package cn.com.scitc.studentmanagement.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Result
 * @Description 统一返回结果类
 * @Author liucaijing
 * @Date 2020/10/20 22:26
 * @Version 1.0
 */
@Data
@NoArgsConstructor
public class ResultData {

    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<String, Object>();

    /**
     * 返回静态成功方法
     * @return
     */
    public static ResultData ok() {
        ResultData result = new ResultData();
        result.setSuccess(true);
        result.setCode(ResultCode.SUCCESS);
        result.setMessage("成功!");
        return result;
    }

    /**
     * 返回成功方法
     * @param code
     * @param message
     * @return
     */
    public static ResultData ok(Integer code, String message) {
        ResultData result = new ResultData();
        result.setSuccess(true);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    /**
     * 返回静态失败方法
     * @return
     */
    public static ResultData error() {
        ResultData result = new ResultData();
        result.setSuccess(false);
        result.setCode(ResultCode.ERROR);
        result.setMessage("失败!");
        return result;
    }

    /**
     * 返回失败方法
     * @param code
     * @param message
     * @return
     */
    public static ResultData error(Integer code, String message) {
        ResultData result = new ResultData();
        result.setSuccess(false);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public ResultData success(Boolean success) {
        this.setSuccess(success);
        return this;
    }

    public ResultData message(String message) {
        this.setMessage(message);
        return this;
    }

    public ResultData code(Integer code) {
        this.setCode(code);
        return this;
    }

    public ResultData data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public ResultData data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }

    /**
     * 将字符串返回到客户端
     * @param response
     * @param str
     * @return
     */
    public static String sendStr(HttpServletResponse response, String str) {
        try {
            response.setStatus(200);
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}