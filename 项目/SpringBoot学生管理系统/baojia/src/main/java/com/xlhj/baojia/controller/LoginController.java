package com.xlhj.baojia.controller;

import com.xlhj.baojia.common.ResultCode;
import com.xlhj.baojia.common.ResultData;
import com.xlhj.baojia.entity.SysUser;
import com.xlhj.baojia.service.SysRoleService;
import com.xlhj.baojia.service.SysUserService;
import com.xlhj.baojia.util.JwtTokenUtils;
import com.xlhj.baojia.vo.LoginBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName LoginController
 * @Description 用户登录控制器
 * @Author liucaijing
 * @Date 2020/10/20 22:25
 * @Version 1.0
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class LoginController {

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private SysUserService userService;
    @Autowired
    private SysRoleService roleService;
    @Resource
    private JwtTokenUtils jwtToken;

    /**
     * 登录
     * @return
     */
    @PostMapping("/login")
    public ResultData login(@RequestBody LoginBody loginBody) {
        try {
            SysUser currentUser = userService.validateUser(loginBody);
            if (currentUser != null) {
                String token = jwtToken.generateToken(currentUser);
                return ResultData.ok(ResultCode.SUCCESS, "登录成功!").data("token", token);
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
    @GetMapping("info")
    public ResultData getInfo(@RequestParam String token) {
        String username = jwtToken.getUsernameFromToken(token);
        SysUser currentUser = userService.selectUserByUsername(username);
        Set<String> roleSet = new HashSet<>();
        if (currentUser != null) {
            roleSet = roleService.selectRoleCodeByUserId(currentUser.getId());
            Boolean flag = jwtToken.validateToken(token, currentUser.getUserName());
            if (flag && !roleSet.isEmpty()) {
                return ResultData.ok().data("roles", roleSet).data("introduction", currentUser.getIntroduction()).data("name", currentUser.getUserName()).data("avatar", currentUser.getAvatar());
            } else {
                return ResultData.error();
            }
        } else {
            return ResultData.error();
        }
    }

    /**
     * 退出
     * @return
     */
    @PostMapping("logout")
    @ResponseBody
    public ResultData logout() {
        return ResultData.ok();
    }
}
