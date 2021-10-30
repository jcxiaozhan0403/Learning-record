package cn.com.scitc.studentmanager.controller;

import cn.com.scitc.studentmanager.common.ResultData;
import cn.com.scitc.studentmanager.pojo.User;
import cn.com.scitc.studentmanager.service.impl.UserServiceImpl;
import cn.com.scitc.studentmanager.vo.LoginBody;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author John.Cena
 * @date 2021/10/15 11:35
 * @Description: 用户控制器
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;
    @Autowired
    User user;

    /**
     *
     * @param loginBody
     * @return
     * 登录验证
     */
    @PostMapping("/login")
    public ResultData login(@RequestBody LoginBody loginBody) {
        boolean validate = userServiceImpl.validate(loginBody.getUsername(),loginBody.getPassword());
        if(validate) {
            String token = UUID.randomUUID().toString();
            int id = userServiceImpl.findIdByUsername(loginBody.getUsername());
            userServiceImpl.createToken(token,id);
            return ResultData.ok().data("token", token);
        }else {
            return  ResultData.error().message("登录失败");
        }
    }

    /**
     *
     * @param token
     * @return
     * 获取用户信息
     */
    @GetMapping("info")
    public ResultData getInfo(@RequestParam String token) {
        user = userServiceImpl.selectUserByToken(token);
        return ResultData.ok().data("id",user.getId()).data("name",user.getName()).data("avatar", user.getAvatar()).data("username", user.getUsername());
    }


    /**
     *
     * @return
     * 注销
     */
    @PostMapping("logout")
    @ResponseBody
    public ResultData logout() {
        userServiceImpl.cleanToken();
        return ResultData.ok();
    }

    /**
     *
     * @param user
     * @return
     * 更新用户信息
     */
    @PostMapping("/info/update")
    public ResultData updateUserInfo(@RequestBody User user) {
        userServiceImpl.updateUserInfo(user);
        return ResultData.ok();
    }

    /**
     *
     * @param jsonObject
     * @return
     * 更新密码
     */
    @PostMapping("/info/updatePassword")
    public ResultData updatePassword(@RequestBody JSONObject jsonObject) {
        return userServiceImpl.updatePassword(jsonObject);
    }

    /**
     *
     * @param user
     * @return
     * 添加管理员
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResultData addUser(@RequestBody User user){
        userServiceImpl.addUser(user);
        return ResultData.ok();
    }
}
