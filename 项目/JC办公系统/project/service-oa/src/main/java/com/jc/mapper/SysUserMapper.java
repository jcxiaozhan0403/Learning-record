package com.jc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jc.model.system.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author John.Cena
 * @date 2023/4/4 17:36
 * @Description:
 */
@Mapper
@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {

}
