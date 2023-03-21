package com.jc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jc.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author John.Cena
 * @date 2023/3/18 16:47
 * @Description:
 */
@Mapper
public interface DeptMapper extends BaseMapper<Dept> {
}
