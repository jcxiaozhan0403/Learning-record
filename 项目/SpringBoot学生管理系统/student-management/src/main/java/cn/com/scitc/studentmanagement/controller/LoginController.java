package cn.com.scitc.studentmanagement.controller;

import cn.com.scitc.studentmanagement.common.ResultCode;
import cn.com.scitc.studentmanagement.common.ResultData;
import cn.com.scitc.studentmanagement.model.LoginBody;
import cn.com.scitc.studentmanagement.model.Manager;
import cn.com.scitc.studentmanagement.model.Token;
import cn.com.scitc.studentmanagement.servise.ManagerServise;
import com.power.common.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/manager")
public class LoginController {
    @Autowired
    private ManagerServise managerServise;
    @Autowired
    private Token token;

    private String tokenValue;

    /**
     * 登录
     * @return
     */
    @CrossOrigin
    @PostMapping("/login")
    @ResponseBody
    public ResultData login(@RequestBody LoginBody loginBody) {
        try {
            String pwd = managerServise.selectByUserName(loginBody.getUsername()).getPwd();
            if (pwd.equals(loginBody.getPassword())) {
                tokenValue = UUIDUtil.getUuid();
                token.setToken(tokenValue);
                return ResultData.ok(ResultCode.SUCCESS, "登录成功!").data("token", tokenValue);
            } else {
                return ResultData.error(ResultCode.ERROR, "用户名或密码不正确!");
            }
        } catch (Exception e) {
            return ResultData.error(ResultCode.ERROR, e.getMessage());
        }
    }

    /**
     * 获取用户信息
     * @return
     */
    @CrossOrigin
    @GetMapping("/info")
    @ResponseBody
    public ResultData getInfo(@RequestParam String token) {
        Manager manager = managerServise.selectByPrimaryKey(1);
        return ResultData.ok().data("introduction", manager.getIntroduction()).data("name", manager.getUsername()).data("avatar", manager.getAvatar());
    }

    /**
     * 退出
     * @return
     */
    @CrossOrigin
    @PostMapping("/logout")
    @ResponseBody
    public ResultData logout() {
        return ResultData.ok();
    }
}
