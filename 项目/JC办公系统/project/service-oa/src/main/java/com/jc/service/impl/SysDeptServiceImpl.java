package com.jc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jc.mapper.SysDeptMapper;
import com.jc.model.system.SysDept;
import com.jc.service.SysDeptService;
import com.jc.vo.system.SysDeptQueryVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author John.Cena
 * @Description:
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements SysDeptService {

    @Override
    public Page<SysDept> querySysDeptPage(Page<SysDept> page, SysDeptQueryVo sysDeptQueryVo) {
        LambdaQueryWrapper<SysDept> wrapper = new LambdaQueryWrapper<>();
        String deptName = sysDeptQueryVo.getName();
        if (!StringUtils.isEmpty(deptName)) {
            wrapper.like(SysDept::getName, deptName);
        }
        return baseMapper.selectPage(page, wrapper);
    }

    @Override
    public void updateStatus(Long id, Integer status) {
        SysDept dept = new SysDept();
        dept.setId(id);
        dept.setStatus(status);
        baseMapper.updateById(dept);
    }
}

