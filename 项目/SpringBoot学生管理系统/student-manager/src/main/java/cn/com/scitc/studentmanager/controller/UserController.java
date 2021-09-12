package cn.com.scitc.studentmanager.controller;

import cn.com.scitc.studentmanager.common.ResultData;
import cn.com.scitc.studentmanager.pojo.User;
import cn.com.scitc.studentmanager.service.impl.UserServiceImpl;
import cn.com.scitc.studentmanager.vo.LoginBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;
    @Autowired
    User user;

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


    @GetMapping("info")
    public ResultData getInfo(@RequestParam String token) {
        user = userServiceImpl.selectUserByToken(token);
        return ResultData.ok().data("name",user.getName()).data("avatar", user.getAvatar()).data("username", user.getUsername());
    }


    @PostMapping("logout")
    @ResponseBody
    public ResultData logout() {
        userServiceImpl.cleanToken();
        return ResultData.ok();
    }
}
