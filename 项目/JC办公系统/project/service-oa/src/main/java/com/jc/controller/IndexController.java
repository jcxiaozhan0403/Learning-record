package com.jc.controller;

import com.jc.common.handler.CustomException;
import com.jc.common.jwt.JwtHelper;
import com.jc.common.result.Result;
import com.jc.common.utils.MD5;
import com.jc.model.system.SysLoginLog;
import com.jc.model.system.SysUser;
import com.jc.service.SysLoginLogService;
import com.jc.service.SysMenuService;
import com.jc.service.SysUserService;
import com.jc.vo.system.LoginVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 后台登录登出
 * @author John.Cena
 * @Description:
 */
@Api(tags = "后台登录管理")
@RestController
@RequestMapping("/admin/system/index")
public class IndexController {

    @Autowired
    SysUserService sysUserService;
    @Autowired
    SysMenuService sysMenuService;
    @Autowired
    SysLoginLogService sysLoginLogService;

    /**
     * 登录
     * @return
     */
    @ApiOperation(value = "登录")
    @PostMapping("login")
    public Result login(@RequestBody LoginVo loginVo,HttpServletRequest request) {
        //用户名是唯一的，可以根据用户名查询用户信息
        SysUser sysUser = sysUserService.getByUsername(loginVo.getUsername());
        if(null == sysUser) {
            throw new CustomException(201,"用户不存在");
        }
        if(!MD5.encrypt(loginVo.getPassword()).equals(sysUser.getPassword())) {
            loginFail(sysUser,request);
            throw new CustomException(201,"密码错误");
        }
        if(sysUser.getStatus().intValue() == 0) {
            loginFail(sysUser,request);
            throw new CustomException(201,"用户被禁用");
        }

        loginSuccess(sysUser,request);
        Map<String, Object> map = new HashMap<>();
        map.put("token", JwtHelper.createToken(sysUser.getId(), sysUser.getUsername()));
        return Result.ok(map);
    }
    /**
     * 获取用户信息
     * @return
     */
    @GetMapping("info")
    public Result info(HttpServletRequest request) {
        //1.从请求头获取token
        String token = request.getHeader("token");
        //2.从token获取用户username和id
        Long userId = JwtHelper.getUserId(token);
        String username = JwtHelper.getUsername(token);
        //3.查询用户信息
        Map<String, Object> map = sysUserService.getUserInfo(userId, username);
        return Result.ok(map);
    }
    /**
     * 退出
     * @return
     */
    @PostMapping("logout")
    public Result logout(){
        return Result.ok();
    }


    //登录成功
    public void loginSuccess(SysUser sysUser,HttpServletRequest request){
        System.out.println("==================================================================================");
        System.out.println("执行");
        System.out.println("==================================================================================");
        SysLoginLog loginLog = new SysLoginLog();
        loginLog.setUsername(sysUser.getUsername());
        loginLog.setIpaddr(request.getRemoteAddr()); // 获取登录IP地址
        loginLog.setStatus(1); // 登录状态，1表示成功
        loginLog.setMsg("登录成功"); // 登录提示信息
        loginLog.setAccessTime(new Date()); // 访问时间，当前时间
        sysLoginLogService.save(loginLog);
    }

//    //登录成功
//    public void loginSuccess(SysUser sysUser){
//        System.out.println("==================================================================================");
//        System.out.println("执行");
//        System.out.println("==================================================================================");
//        SysLoginLog loginLog = new SysLoginLog();
//        loginLog.setUsername(sysUser.getUsername());
//        loginLog.setIpaddr("0.0.0.0"); // 获取登录IP地址
//        loginLog.setStatus(1); // 登录状态，1表示成功
//        loginLog.setMsg("登录成功"); // 登录提示信息
//        loginLog.setAccessTime(new Date()); // 访问时间，当前时间
//        sysLoginLogService.save(loginLog);
//    }

    //登录失败
    public void loginFail(SysUser sysUser,HttpServletRequest request){
        SysLoginLog loginLog = new SysLoginLog();
        loginLog.setUsername(sysUser.getUsername());
        loginLog.setIpaddr(request.getRemoteAddr()); // 获取登录IP地址
        loginLog.setStatus(0); // 登录状态，1表示成功
        loginLog.setMsg("失败"); // 登录提示信息
        loginLog.setAccessTime(new Date()); // 访问时间，当前时间
        sysLoginLogService.save(loginLog);
    }

}
