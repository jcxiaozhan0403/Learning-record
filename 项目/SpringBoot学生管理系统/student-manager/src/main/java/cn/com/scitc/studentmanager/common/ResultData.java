package cn.com.scitc.studentmanager.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @author John.Cena
 * @date 2021/10/15 11:35
 * @Description: 统一返回结果
 * 状态、状态码、消息
 */
public class ResultData {

    private Boolean success;

    private Integer code;

    private String message;

    private Map<String, Object> data = new HashMap<String, Object>();

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    /**
     *
     * @return ResultData
     * 返回成功
     */
    public static ResultData ok() {
        ResultData result = new ResultData();
        result.setSuccess(true);
        result.setCode(ResultCode.SUCCESS);
        result.setMessage("成功!");
        return result;
    }

    /**
     *
     * @param code
     * @param message
     * @return
     * 返回成功
     */
    public static ResultData ok(Integer code, String message) {
        ResultData result = new ResultData();
        result.setSuccess(true);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    /**
     *
     * @return
     * 返回失败
     */
    public static ResultData error() {
        ResultData result = new ResultData();
        result.setSuccess(false);
        result.setCode(ResultCode.ERROR);
        result.setMessage("失败!");
        return result;
    }

    /**
     *
     * @param code
     * @param message
     * @return
     * 返回失败
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

    @Override
    public String toString() {
        return "ResultData{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
