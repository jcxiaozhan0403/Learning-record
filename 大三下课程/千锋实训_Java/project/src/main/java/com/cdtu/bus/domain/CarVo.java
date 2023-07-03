package com.cdtu.bus.domain;

/**
 * @Author:千锋强哥
 * @organization: 千锋教研院
 * @Version: 1.0
 */
public class CarVo extends Car{
    //1.分页参数
    private Integer page;  //当前页
    private Integer limit; //每页现实条数
    private String[] ids; //存储多个车牌号 , 用于批量删除

    public CarVo() {
    }

    public CarVo(Integer page, Integer limit, String[] ids) {
        this.page = page;
        this.limit = limit;
        this.ids = ids;
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

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }
}
