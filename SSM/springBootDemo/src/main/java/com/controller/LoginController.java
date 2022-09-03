package com.controller;

import com.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author John.Cena
 * @date 2022/9/1 9:57
 * @Description:
 */
@Controller
public class LoginController {

    @RequestMapping("/demo")
    public String myTest(Model model){
        User user = new User(1, "John", "123456", 1, 1);

        model.addAttribute("user",user);

        return "demo";
    }
}
