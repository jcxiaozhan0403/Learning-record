package com.cdtu.sys.service;

import com.cdtu.sys.domain.LogInfo;
import com.cdtu.sys.domain.LogInfoVo;
import com.cdtu.sys.utils.DataGridView;

public interface ILogInfoService {
    DataGridView queryAllLogInfo(LogInfoVo logInfoVo);

    void deleteLogInfo(Integer id);

    void deleteBatchLogInfo(LogInfoVo logInfoVo);

    /**
     * 插入登录日志
     * @param logInfo 登录日志对象
     */
    void insertLogInfo(LogInfo logInfo);
}
