package com.cdtu.sys.utils;
/**
 * 数据表格工具类
 * @Author:千锋强哥
 * @organization: 千锋教研院
 * @Version: 1.0
 */
public class DataGridView {
    /**
     * 封装layui数据表格的数据对象
     */
    private Integer code=0;
    private String msg="";
    private Long count;
    private Object data; //表格展示的数据

    public DataGridView() {
    }

    public DataGridView(Object data) {
        super();
        this.data = data;
    }

    public DataGridView(Long count, Object data) {
        super();
        this.count = count;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
