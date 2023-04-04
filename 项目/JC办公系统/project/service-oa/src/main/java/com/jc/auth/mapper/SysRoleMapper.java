package com.jc.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jc.model.system.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author John.Cena
 * @date 2023/3/9 19:41
 * @Description:
 */
@Mapper
@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {
}
