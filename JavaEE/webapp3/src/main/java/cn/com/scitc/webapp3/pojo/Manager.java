package cn.com.scitc.webapp3.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Manager {
    private Integer id;
    private String loginId;
    private String realName;
    private String pwd;
    private Integer loginCount;
    private Timestamp lastLoginDt;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "loginId", nullable = false, length = 20)
    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    @Basic
    @Column(name = "realName", nullable = true, length = 10)
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Basic
    @Column(name = "pwd", nullable = true, length = 200)
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Basic
    @Column(name = "loginCount", nullable = true)
    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    @Basic
    @Column(name = "lastLoginDt", nullable = true)
    public Timestamp getLastLoginDt() {
        return lastLoginDt;
    }

    public void setLastLoginDt(Timestamp lastLoginDt) {
        this.lastLoginDt = lastLoginDt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return Objects.equals(id, manager.id) && Objects.equals(loginId, manager.loginId) && Objects.equals(realName, manager.realName) && Objects.equals(pwd, manager.pwd) && Objects.equals(loginCount, manager.loginCount) && Objects.equals(lastLoginDt, manager.lastLoginDt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, loginId, realName, pwd, loginCount, lastLoginDt);
    }
}
