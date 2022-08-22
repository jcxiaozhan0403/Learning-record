package cn.com.controller;

import cn.com.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author John.Cena
 * @date 2022/8/21 19:41
 * @Description:
 */
@Controller
public class ResultSpringMVC {
    @RequestMapping("/test")
    public String test(User user, Model model){
        model.addAttribute("name",user.getName());
        model.addAttribute("age",user.getAge());
        return "test";
    }
}