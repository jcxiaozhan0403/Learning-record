package com.jc.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jc.common.result.Result;
import com.jc.model.system.SysDept;
import com.jc.service.SysDeptService;
import com.jc.vo.system.SysDeptQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author John.Cena
 * @date 2023/7/17 11:14
 * @Description: 部门管理
 */
@Api(tags = "部门管理")
@RestController
@RequestMapping("/admin/system/sysDept")
@CrossOrigin
public class SysDeptController {

    @Autowired
    private SysDeptService sysDeptService;

    /**
     * 条件查询部门列表（带分页）
     * @param page 当前页
     * @param limit 每页显示记录数
     * @param sysDeptQueryVo 条件对象
     * @return
     */
    @PreAuthorize("hasAuthority('bnt.sysDept.list')")
    @ApiOperation("部门条件分页查询")
    @GetMapping("{page}/{limit}")
    public Result index(@PathVariable Long page,
                        @PathVariable Long limit,
                        SysDeptQueryVo sysDeptQueryVo) {
        Page<SysDept> pageParam = new Page<>(page, limit);
        Page<SysDept> pageModel = sysDeptService.querySysDeptPage(pageParam, sysDeptQueryVo);
        return Result.ok(pageModel);
    }

    @PreAuthorize("hasAuthority('bnt.sysDept.list')")
    @ApiOperation(value = "根据 ID 获取部门")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        SysDept dept = sysDeptService.getById(id);
        return Result.ok(dept);
    }

    @PreAuthorize("hasAuthority('bnt.sysDept.add')")
    @ApiOperation(value = "新增部门")
    @PostMapping("save")
    public Result save(@RequestBody SysDept dept) {
        sysDeptService.save(dept);
        return Result.ok();
    }

    @PreAuthorize("hasAuthority('bnt.sysDept.update')")
    @ApiOperation(value = "更新部门")
    @PutMapping("update")
    public Result updateById(@RequestBody SysDept dept) {
        sysDeptService.updateById(dept);
        return Result.ok();
    }

    @PreAuthorize("hasAuthority('bnt.sysDept.remove')")
    @ApiOperation(value = "删除部门")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        sysDeptService.removeById(id);
        return Result.ok();
    }

    @PreAuthorize("hasAuthority('bnt.sysDept.update')")
    @ApiOperation(value = "更新部门状态")
    @GetMapping("updateStatus/{id}/{status}")
    public Result updateStatus(@PathVariable Long id, @PathVariable Integer status) {
        sysDeptService.updateStatus(id, status);
        return Result.ok();
    }
}

