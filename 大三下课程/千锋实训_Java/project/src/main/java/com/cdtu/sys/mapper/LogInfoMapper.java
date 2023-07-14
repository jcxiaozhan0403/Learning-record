package com.cdtu.sys.mapper;

import com.cdtu.sys.domain.LogInfo;
import com.cdtu.sys.domain.LogInfoVo;

import java.util.List;

public interface LogInfoMapper {
    List<LogInfo> queryAllLogInfo(LogInfoVo logInfoVo);

    void deleteByPrimaryKey(Integer id);

    /**
     * 插入登录日志
     * @param logInfo 登录日志对象
     */
    void insertLogInfo(LogInfo logInfo);
}
