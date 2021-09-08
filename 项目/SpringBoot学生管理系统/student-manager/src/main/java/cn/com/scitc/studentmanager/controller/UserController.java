package cn.com.scitc.studentmanager.controller;

import cn.com.scitc.studentmanager.common.ResultData;
import cn.com.scitc.studentmanager.vo.LoginBody;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @PostMapping("/login")
    public ResultData login(@RequestBody LoginBody loginBody) {
        return ResultData.ok().data("token","18982379506");
    }


    @GetMapping("info")
    public ResultData getInfo(@RequestParam String token) {
        //"roles":["admin"],"introduction":"I am a super administrator","avatar":"https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif","name":"Super Admin"
        return ResultData.ok().data("introduction", "I am a super administrator").data("name", "Super Admin").data("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }
}
