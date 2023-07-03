package com.cdtu.bus.domain;

/**
 * @Author:千锋强哥
 * @organization: 千锋教研院
 * @Version: 1.0
 * 客户的视图对象
 */
public class CustomerVo extends Customer{
    //分页的参数
    private Integer page;
    private Integer limit;


    public CustomerVo(Integer page, Integer limit, String[] ids) {
        this.page = page;
        this.limit = limit;
        this.ids = ids;
    }

    //接受多个id
    private String [] ids;

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }

    public CustomerVo() {
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
