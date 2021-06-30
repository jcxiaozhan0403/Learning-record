package cn.com.scitc.project.model;

import java.util.Date;

public class Log {
    private Integer id;
    private Date time;
    private String loginid;
    private String event;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getLoginid() {
        return loginid;
    }

    public void setLoginid(String loginid) {
        this.loginid = loginid;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", time=" + time +
                ", loginId='" + loginid + '\'' +
                ", event='" + event + '\'' +
                '}';
    }
}
