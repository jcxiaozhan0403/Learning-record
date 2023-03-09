package com.jc.auth.controller;

import com.jc.auth.service.SysRoleService;
import com.jc.common.result.Result;
import com.jc.model.system.SysRole;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author John.Cena
 * @date 2023/3/9 20:27
 * @Description:
 */
@Api(tags = "角色管理")
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

//    @GetMapping("findAll")
//    public List<SysRole> findAll() {
//        List<SysRole> roleList = sysRoleService.list();
//        return roleList;
//    }

    @ApiOperation(value = "获取全部角色列表")
    @GetMapping("findAll")
    public Result<List<SysRole>> findAll() {
        List<SysRole> roleList = sysRoleService.list();
        return Result.ok(roleList);
    }
}
