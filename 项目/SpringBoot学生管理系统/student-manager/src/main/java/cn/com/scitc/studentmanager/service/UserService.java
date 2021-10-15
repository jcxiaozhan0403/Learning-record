package cn.com.scitc.studentmanager.service;

import cn.com.scitc.studentmanager.common.ResultData;
import cn.com.scitc.studentmanager.pojo.User;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author John.Cena
 * @date 2021/10/15 11:35
 * @Description: 用户服务接口
 */
@Mapper
public interface UserService {
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
     * @param jsonObject
     * @return
     * 更新密码
     */
    ResultData updatePassword(JSONObject jsonObject);
}
