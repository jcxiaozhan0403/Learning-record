package cn.com.scitc.webapp1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/list")
    public String list() {
        return "list";
    }

    @RequestMapping("/edit")
    public String edit() {
        return "edit";
    }
}
