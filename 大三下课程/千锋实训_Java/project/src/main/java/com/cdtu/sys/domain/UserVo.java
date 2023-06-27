package com.cdtu.sys.domain;

/**
 * @Author:千锋强哥
 * @organization: 千锋教研院
 * @Version: 1.0
 * UserVo对象  用户的视图对象  V  view  O object
 *
 * 视图对象的作用：
 * 1.前台展示数据的时候会用
 * 2.参数传递的时候会用
 *
 */
public class UserVo extends User{
    //分页参数
    private Integer limit; //每页显示多个
    private Integer page; //当前页码

    private String code; //验证码

    private Integer[] ids; //后期批量删除  会传入多个userid


    public UserVo(Integer limit, Integer page, String code, Integer[] ids) {
        this.limit = limit;
        this.page = page;
        this.code = code;
        this.ids = ids;
    }

    public UserVo() {
    }

    public Integer[] getIds() {
        return ids;
    }

    public void setIds(Integer[] ids) {
        this.ids = ids;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
