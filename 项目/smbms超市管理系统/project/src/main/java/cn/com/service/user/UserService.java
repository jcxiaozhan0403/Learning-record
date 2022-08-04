package cn.com.service.user;

import cn.com.dao.user.impl.UserDaoImpl;
import cn.com.pojo.User;

/**
 * @author John.Cena
 * @date 2022/8/2 17:39
 * @Description:
 */
public interface UserService {
    User getUser(String userCode);

    int updatePwd(String userCode,String newpassword);
}
