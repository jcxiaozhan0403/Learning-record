package com.jc.controller;

import com.jc.common.handler.CustomException;
import com.jc.common.jwt.JwtHelper;
import com.jc.common.result.Result;
import com.jc.common.utils.MD5;
import com.jc.model.system.SysUser;
import com.jc.service.SysUserService;
import com.jc.vo.system.LoginVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 后台登录登出
 * @author John.Cena
 * @date 2023/3/13 22:34
 * @Description:
 */
@Api(tags = "后台登录管理")
@RestController
@RequestMapping("/admin/system/index")
public class IndexController {

    @Autowired
    SysUserService sysUserService;


    /**
     * 登录
     * @return
     */
    @ApiOperation(value = "登录")
    @PostMapping("login")
    public Result login(@RequestBody LoginVo loginVo) {
        SysUser sysUser = sysUserService.getByUsername(loginVo.getUsername());
        if(null == sysUser) {
            throw new CustomException(201,"用户不存在");
        }
        if(!MD5.encrypt(loginVo.getPassword()).equals(loginVo.getPassword())) {
            throw new CustomException(201,"密码错误");
        }
        if(sysUser.getStatus().intValue() == 0) {
            throw new CustomException(201,"用户被禁用");
        }

        Map<String, Object> map = new HashMap<>();
        map.put("token", JwtHelper.createToken(sysUser.getId(), sysUser.getUsername()));
        return Result.ok(map);
    }
    /**
     * 获取用户信息
     * @return
     */
    @GetMapping("info")
    public Result info() {
        Map<String, Object> map = new HashMap<>();
        map.put("roles","[admin]");
        map.put("name","admin");
        map.put("avatar","https://oss.aliyuncs.com/aliyun_id_photo_bucket/default_handsome.jpg");
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

}
