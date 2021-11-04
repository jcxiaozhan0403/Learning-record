package cn.com.huadi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author John.Cena
 * @date 2021/11/3 12:15
 * @Description: 普通用户个人中心控制类
 */
@Controller
public class UserController {

    @GetMapping("/userCenter")
    public String userCenter() {
        return "userCenter";
    }

    @GetMapping("/course")
    public String course() {
        return "course";
    }

    @GetMapping("/favorites")
    public String favorites() {
        return "favorites";
    }
}
