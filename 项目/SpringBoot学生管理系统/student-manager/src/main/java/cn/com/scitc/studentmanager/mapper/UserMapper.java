package cn.com.scitc.studentmanager.mapper;

import cn.com.scitc.studentmanager.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author John.Cena
 * @date 2021/10/15 11:35
 * @Description: 用户模块
 */
@Mapper
public interface UserMapper {
    /**
     *
     * @param token
     * @return
     * 根据token查询用户信息
     */
    User selectUserByToken(String token);

    /**
     *
     * @param token
     * @param user_id
     * 验证通过创建token
     */
    void createToken(String token,int user_id);

    /**
     *
     * @param username
     * @return
     * 根据用户名查询id
     */
    int findIdByUsername(String username);

    /**
     * 清空token表
     */
    void cleanToken();

    /**
     *
     * @param user
     * 更新用户信息
     */
    void updateUserInfo(User user);

    /**
     *
     * @param id
     * @return
     * 通过id查询一个用户
     */
    User findById(int id);

    /**
     *
     * @param user
     * 更新密码
     */
    void updateUserPassword(User user);

    /**
     *
     * @param username
     * @return
     * 根据用户名查询密码
     */
    String findPassWordByUsername(String username);
}
