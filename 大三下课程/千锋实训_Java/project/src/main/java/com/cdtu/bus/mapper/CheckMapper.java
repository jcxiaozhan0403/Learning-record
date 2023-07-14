package com.cdtu.bus.mapper;

import com.cdtu.bus.domain.Check;
import com.cdtu.bus.domain.CheckVo;

import java.util.List;

public interface CheckMapper {
    /**
     * 添加检查单
     * @param checkVo
     */
    void insertSelective(CheckVo checkVo);

    /**
     * 查询所有的检查单
     * @param checkVo
     * @return
     */
    List<Check> queryAllCheck(CheckVo checkVo);

    void updateByPrimaryKeySelective(CheckVo checkVo);

    void deleteByPrimaryKey(String checkid);
}
