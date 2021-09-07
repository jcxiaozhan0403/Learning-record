package com.xlhj.baojia.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xlhj.baojia.entity.SysRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName SysRoleMapper
 * @Description 角色管理持久层接口
 * @Author liucaijing
 * @Date 2020/10/20 22:01
 * @Version 1.0
 */
@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 根据用户ID查询角色
     * @param userId
     * @return
     */
    List<SysRole> selectRoleCodeByUserId(Long userId);
}
