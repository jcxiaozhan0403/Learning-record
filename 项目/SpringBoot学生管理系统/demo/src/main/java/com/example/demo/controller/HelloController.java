package com.example.demo.controller;

import com.example.demo.common.ResponseEnum;
import com.example.demo.common.ServerResponse;
import com.example.demo.pojo.Token;
import com.example.demo.vo.LoginBody;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class HelloController {

    /**
     * 登录
     * @return
     */
    @PostMapping("/login")
    public ServerResponse login(@RequestBody LoginBody loginBody) {
        System.out.println("获取token");
        Token token = new Token("18982379506");
        System.out.println(token);
        return ServerResponse.getInstance().responseEnum(ResponseEnum.LOGIN_SUCCESS).data(token);
    }

    public static void main(String[] args) {
        LoginBody loginBody = new LoginBody();
        HelloController helloController = new HelloController();

         // {"code":20000,"data":{token:"18982379506"},"message":"登录成功"}

        System.out.println(helloController.login(loginBody));
    }
}
