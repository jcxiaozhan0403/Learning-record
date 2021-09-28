package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.User;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

    @PostMapping("/login")
    public String login(String username, String password,HttpServletRequest request) throws IOException {

        try{
            User user = userService.findInfoByUsername(username);
            if (user.getPassword().equals(password)) {
                request.getSession().setAttribute("currentUser",user);
                return "redirect:/student/list";
            }
        }catch (Exception e){
            System.out.println("登录错误");
            return "redirect:/index.jsp";
        }

        return null;
    }
}
