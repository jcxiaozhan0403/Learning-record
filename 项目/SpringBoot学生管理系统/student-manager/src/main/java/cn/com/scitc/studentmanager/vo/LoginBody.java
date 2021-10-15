package cn.com.scitc.studentmanager.vo;

/**
 * @author John.Cena
 * @date 2021/10/15 11:35
 * @Description: 前端实体
 * 用户名、密码
 */
public class LoginBody {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
