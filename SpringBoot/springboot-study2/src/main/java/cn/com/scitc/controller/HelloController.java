package cn.com.scitc.controller;

import cn.com.scitc.pojo.User;
import cn.com.scitc.service.AsyncService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author John.Cena
 * @date 2021/10/23 11:37
 * @Description: 控制器
 */
@Controller
public class HelloController {

    @Autowired
    public User user;

    @Autowired
    AsyncService asyncService;

    @ApiOperation("你好接口")
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @ApiOperation("用户接口")
    @GetMapping("/user")
    public String user() {
        user.toString();
        return "hello";
    }

    @RequestMapping("/sync")
    @ResponseBody
    public String sync() {
        asyncService.test();
        return "发送成功";
    }
}
