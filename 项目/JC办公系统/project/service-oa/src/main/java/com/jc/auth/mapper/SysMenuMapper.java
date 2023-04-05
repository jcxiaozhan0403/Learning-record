package com.jc.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jc.model.system.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author John.Cena
 * @date 2023/4/5 11:23
 * @Description:
 */
@Mapper
@Repository
public interface SysMenuMapper extends BaseMapper<SysMenu> {

}
