package com.jc.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jc.common.utils.MD5;
import com.jc.service.SysUserService;
import com.jc.common.result.Result;
import com.jc.model.system.SysUser;
import com.jc.vo.system.SysUserQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author John.Cena
 * @date 2023/4/4 17:38
 * @Description:
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("/admin/system/sysUser")
@CrossOrigin
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 条件查询(带分页)
     * @param page 当前页
     * @param limit 每页显示记录数
     * @param sysUserQueryVo 条件对象
     * @return
     */
    @PreAuthorize("hasAuthority('bnt.sysUser.list')")
    @ApiOperation("用户条件分页查询")
    @GetMapping("{page}/{limit}")
    public Result index(@PathVariable Long page,
                        @PathVariable Long limit,
                        SysUserQueryVo sysUserQueryVo) {
        //1.创建一个Page对象，用于传递分页参数信息
        Page<SysUser> pageParam = new Page<>(page,limit);

        //2.封装条件，判断条件是否为空，不为空使用wrapper进行查询条件的编写
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        //获取条件值
        String keyWord = sysUserQueryVo.getKeyword();
        String createTimeBegin = sysUserQueryVo.getCreateTimeBegin();
        String createTimeEnd = sysUserQueryVo.getCreateTimeEnd();

        if(!StringUtils.isEmpty(keyWord)) {
            wrapper
                    .like(SysUser::getUsername,keyWord)
                    .or()
                    .like(SysUser::getName,keyWord)
                    .or()
                    .like(SysUser::getPhone,keyWord);
        }

        if(!StringUtils.isEmpty(createTimeBegin)) {
            //ge 大于等于
            wrapper.ge(SysUser::getCreateTime,createTimeBegin);
        }

        if(!StringUtils.isEmpty(createTimeEnd)) {
            //le 小于等于
            wrapper.le(SysUser::getCreateTime,createTimeEnd);
        }

        //3.调用方法实现分页查询，并封装为一个Page对象
        Page<SysUser> pageModel = sysUserService.page(pageParam, wrapper);
        return Result.ok(pageModel);
    }

    @PreAuthorize("hasAuthority('bnt.sysUser.list')")
    @ApiOperation(value = "根据id获取用户")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        SysUser user = sysUserService.getById(id);
        return Result.ok(user);
    }

    @PreAuthorize("hasAuthority('bnt.sysUser.add')")
    @ApiOperation(value = "新增用户")
    @PostMapping("save")
    public Result save(@RequestBody SysUser user) {
        user.setPassword(MD5.encrypt(user.getPassword()));
        sysUserService.save(user);
        return Result.ok();
    }

    @PreAuthorize("hasAuthority('bnt.sysUser.update')")
    @ApiOperation(value = "更新用户")
    @PutMapping("update")
    public Result updateById(@RequestBody SysUser user) {
        sysUserService.updateById(user);
        return Result.ok();
    }

    @PreAuthorize("hasAuthority('bnt.sysUser.remove')")
    @ApiOperation(value = "删除用户")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        sysUserService.removeById(id);
        return Result.ok();
    }

    @PreAuthorize("hasAuthority('bnt.sysUser.update')")
    @ApiOperation(value = "更新用户状态")
    @GetMapping("updateStatus/{id}/{status}")
    public Result updateStatus(@PathVariable Long id, @PathVariable Integer status) {
        sysUserService.updateStatus(id, status);
        return Result.ok();
    }

    @PreAuthorize("hasAuthority('bnt.sysUser.list')")
    @ApiOperation(value = "获取当前用户基本信息")
    @GetMapping("getCurrentUser")
    public Result getCurrentUser() {
        return Result.ok(sysUserService.getCurrentUser());
    }

    @PreAuthorize("hasAuthority('bnt.sysUser.resetPwd')")
    @ApiOperation(value = "重置用户密码")
    @GetMapping("resetPwd/{id}")
    public Result resetPassword(@PathVariable Long id) {
        SysUser user = sysUserService.getById(id);

        if (user == null) {
            return Result.fail("用户不存在");
        }

        // 更新用户密码
        user.setPassword(MD5.encrypt("123456"));
        sysUserService.updateById(user);

        return Result.ok();
    }
}
