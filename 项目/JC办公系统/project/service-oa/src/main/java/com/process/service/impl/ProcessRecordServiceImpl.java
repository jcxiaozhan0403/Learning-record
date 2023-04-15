package com.process.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jc.custom.LoginUserInfoHelper;
import com.jc.model.process.ProcessRecord;
import com.jc.model.system.SysUser;
import com.jc.service.SysUserService;
import com.process.mapper.ProcessRecordMapper;
import com.process.service.ProcessRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author John.Cena
 * @date 2023/4/14 21:32
 * @Description:
 */
@Service
@SuppressWarnings({"unchecked", "rawtypes"})
public class ProcessRecordServiceImpl extends ServiceImpl<ProcessRecordMapper, ProcessRecord> implements ProcessRecordService {

    @Autowired
    private ProcessRecordMapper processRecordMapper;

    @Autowired
    private SysUserService sysUserService;

    @Override
    public void record(Long processId, Integer status, String description) {
        //获取当前用户信息
        SysUser sysUser = sysUserService.getById(LoginUserInfoHelper.getUserId());
        ProcessRecord processRecord = new ProcessRecord();
        //设置流程id
        processRecord.setProcessId(processId);
        //设置流程状态
        processRecord.setStatus(status);
        //设置流程描述
        processRecord.setDescription(description);
        //设置用户id
        processRecord.setOperateUserId(sysUser.getId());
        //设置用户名字
        processRecord.setOperateUser(sysUser.getName());
        processRecordMapper.insert(processRecord);
    }

}
