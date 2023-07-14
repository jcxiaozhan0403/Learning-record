package com.cdtu.sys.domain;

public class Role {
    private Integer roleid;

    private String rolename;

    private String roledesc;

    private Integer available;

    public Role() {
    }

    public Role(Integer roleid, String rolename, String roledesc, Integer available) {
        this.roleid = roleid;
        this.rolename = rolename;
        this.roledesc = roledesc;
        this.available = available;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRoledesc() {
        return roledesc;
    }

    public void setRoledesc(String roledesc) {
        this.roledesc = roledesc;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }
}
