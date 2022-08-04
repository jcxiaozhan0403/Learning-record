package cn.com.dao.user;

import cn.com.pojo.User;

/**
 * @author John.Cena
 * @date 2022/8/2 16:53
 * @Description:
 */
public interface UserDao {
    User getUser(String userCode);

    int updatePwd(String userCode,String newpassword);
}
