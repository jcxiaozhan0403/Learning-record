package com.cdtu.bus.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Author:千锋强哥
 * @organization: 千锋教研院
 * @Version: 1.0
 */
public class Car {
    private String carnumber; //车牌

    private String cartype;  //车辆类型  轿车  suv

    private String color;

    private Double price;

    private Double rentprice;  //租金

    private Double deposit;   //押金

    private Integer isrenting;  //是否出租

    private String description;

    private String carimg;   //图片路径

    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss",timezone = "GTM+8")
    private Date createtime;

    public Car() {
    }

    public Car(String carnumber, String cartype, String color, Double price, Double rentprice, Double deposit, Integer isrenting, String description, String carimg, Date createtime) {
        this.carnumber = carnumber;
        this.cartype = cartype;
        this.color = color;
        this.price = price;
        this.rentprice = rentprice;
        this.deposit = deposit;
        this.isrenting = isrenting;
        this.description = description;
        this.carimg = carimg;
        this.createtime = createtime;
    }

    public String getCarnumber() {
        return carnumber;
    }

    public void setCarnumber(String carnumber) {
        this.carnumber = carnumber;
    }

    public String getCartype() {
        return cartype;
    }

    public void setCartype(String cartype) {
        this.cartype = cartype;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getRentprice() {
        return rentprice;
    }

    public void setRentprice(Double rentprice) {
        this.rentprice = rentprice;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Integer getIsrenting() {
        return isrenting;
    }

    public void setIsrenting(Integer isrenting) {
        this.isrenting = isrenting;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCarimg() {
        return carimg;
    }

    public void setCarimg(String carimg) {
        this.carimg = carimg;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
