package com.cdtu.bus.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Author:千锋强哥
 * @organization: 千锋教研院
 * @Version: 1.0
 */
public class Customer {
    private String identity;

    private String custname;

    private Integer sex;

    private String address;

    private String phone;

    private String career;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createtime;

    public Customer() {
    }

    public Customer(String identity, String custname, Integer sex, String address, String phone, String career, Date createtime) {
        this.identity = identity;
        this.custname = custname;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
        this.career = career;
        this.createtime = createtime;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
