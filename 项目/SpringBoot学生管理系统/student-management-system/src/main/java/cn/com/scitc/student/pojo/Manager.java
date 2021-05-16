package cn.com.scitc.student.pojo;

import java.util.Date;

public class Manager {
    private Integer id;
    private String loginid;
    private String realname;
    private String pwd;
    private Integer logincount;
    private Date lastlogindt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginid() {
        return loginid;
    }

    public void setLoginid(String loginid) {
        this.loginid = loginid;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getLogincount() {
        return logincount;
    }

    public void setLogincount(Integer logincount) {
        this.logincount = logincount;
    }

    public Date getLastlogindt() {
        return lastlogindt;
    }

    public void setLastlogindt(Date lastlogindt) {
        this.lastlogindt = lastlogindt;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", loginid='" + loginid + '\'' +
                ", realname='" + realname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", logincount=" + logincount +
                ", lastlogindt=" + lastlogindt +
                '}';
    }
}
