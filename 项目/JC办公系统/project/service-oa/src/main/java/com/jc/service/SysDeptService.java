package com.jc.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jc.model.system.SysDept;
import com.jc.vo.system.SysDeptQueryVo;

/**
 * @author John.Cena
 * @date 2023/7/17 14:35
 * @Description:
 */
public interface SysDeptService extends IService<SysDept> {
    Page<SysDept> querySysDeptPage(Page<SysDept> page, SysDeptQueryVo sysDeptQueryVo);
    void updateStatus(Long id, Integer status);
}

