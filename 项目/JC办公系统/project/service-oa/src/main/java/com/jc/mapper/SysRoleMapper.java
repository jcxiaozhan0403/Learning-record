package com.jc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jc.model.system.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author John.Cena
 * @Description:
 */
@Mapper
@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {
}
