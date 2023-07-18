package com.jc.controller;

import com.jc.common.result.Result;
import com.jc.model.system.SysLoginLog;
import com.jc.service.SysLoginLogService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author John.Cena
 * @date 2023/7/18 10:12
 * @Description: 登录日志
 */
@RequestMapping("/admin/system/log")
public class SysLoginLogController {

    @Autowired
    private SysLoginLogService sysLoginLogService;

    @PostMapping("/save")
    @ApiOperation(value = "添加日志")
    public Result save(@RequestBody SysLoginLog loginLog) {
        sysLoginLogService.save(loginLog);
        return Result.ok();
    }
}

