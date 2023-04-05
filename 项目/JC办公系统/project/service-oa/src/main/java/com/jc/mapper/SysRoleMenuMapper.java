package com.jc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jc.model.system.SysRoleMenu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author John.Cena
 * @date 2023/4/5 13:54
 * @Description:
 */
@Mapper
@Repository
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {

}
