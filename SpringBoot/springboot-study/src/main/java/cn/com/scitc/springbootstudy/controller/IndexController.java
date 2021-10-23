package cn.com.scitc.springbootstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author John.Cena
 * @date 2021/10/21 22:36
 * @Description: 主页控制器
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index() {
            System.out.println("登录成功");
            return "index";
    }
}