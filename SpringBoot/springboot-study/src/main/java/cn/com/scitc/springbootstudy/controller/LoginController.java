package cn.com.scitc.springbootstudy.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author John.Cena
 * @date 2021/10/22 7:40
 * @Description: 登录控制器
 */
@Controller
public class LoginController {

//    @RequestMapping(value = {"/login","/"})
//    public String login() {
//        return "login";
//    }

    @RequestMapping(value = "/checklogin")
    public String checklogin(String username, String password, HttpServletRequest request) {
        if (username != null && password != null) {
            System.out.println("登录成功");
            request.getSession().setAttribute("username",username);
            return "/index";
        }
        return "redirect:/login";
    }

    @RequestMapping(value = {"/login"})
    public String login(String username, String password, Model model) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);

        try{
            // 调用shiro，传入token
            subject.login(token);
            return "index";
        }catch (UnknownAccountException e) {
            e.printStackTrace();
            model.addAttribute("msg","用户名错误");
            return "login";
        }catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            model.addAttribute("msg","密码错误");
            return "login";
        }
    }
}
