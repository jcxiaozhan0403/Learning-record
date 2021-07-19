package cn.com.scitc.studentmanagement.controller;

import cn.com.scitc.studentmanagement.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("")
public class LoginController {

    @RequestMapping("/login")
    @ResponseBody
    public User login() {
        User user = new User();
        user.setName("李爽");
        user.setAge(18);
        return user;
    }
}
