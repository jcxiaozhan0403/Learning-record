package com.cdtu.sys.domain;

/**
 * @Author:千锋强哥
 * @organization: 千锋教研院
 * @Version: 1.0
 *
 */
public class User {
    //用户id
    private Integer userid;
    //登录名称
    private String loginname;
    //身份证号码
    private String identity;
    //真实姓名
    private String realname;
    //性别
    private Integer sex;
    //地址
    private String address;
    //电话
    private String phone;
    //密码
    private String pwd;
    //职位
    private String position;
    //用户类型
    private Integer type;
    //是否可用
    private Integer available;

    public User() {
    }

    public User(Integer userid, String loginname, String identity, String realname, Integer sex, String address, String phone, String pwd, String position, Integer type, Integer available) {
        this.userid = userid;
        this.loginname = loginname;
        this.identity = identity;
        this.realname = realname;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
        this.pwd = pwd;
        this.position = position;
        this.type = type;
        this.available = available;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }
}
