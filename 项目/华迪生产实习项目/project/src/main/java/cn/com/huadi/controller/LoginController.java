package cn.com.huadi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author John.Cena
 * @date 2021/11/2 13:35
 * @Description: 登录控制器
 */
@Controller
public class LoginController {

    @GetMapping("/tologin")
    public String toLoginPage() {
       return "login";
    }

    @PostMapping("/login")
    public String loginCheck(@RequestParam("username") String username,
                          @RequestParam("password") String password){
        System.out.println(username);
        System.out.println(password);

        return null;
    }
}
