package cn.com.huadi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author John.Cena
 * @date 2021/11/4 14:41
 * @Description: 管理界面控制器
 */
@Controller
public class ManagerController {

    @GetMapping("/course/list")
    public String courseList() {
        return "/manager/courseList";
    }

    @GetMapping("/user/list")
    public String userList() {
        return "/manager/userList";
    }

}
