package com.xlhj.baojia.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xlhj.baojia.entity.SysUser;
import org.springframework.stereotype.Repository;

/**
 * @ClassName SysUserMapper
 * @Description 用户管理持久层接口
 * @Author liucaijing
 * @Date 2020/10/20 22:00
 * @Version 1.0
 */
@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {
}
