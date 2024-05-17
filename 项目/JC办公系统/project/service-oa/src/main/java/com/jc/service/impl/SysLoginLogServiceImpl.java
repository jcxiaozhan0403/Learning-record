package com.jc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jc.mapper.SysLoginLogMapper;
import com.jc.model.system.SysLoginLog;
import com.jc.service.SysLoginLogService;
import org.springframework.stereotype.Service;

/**
 * @author John.Cena
 * @Description:
 */
@Service
public class SysLoginLogServiceImpl extends ServiceImpl<SysLoginLogMapper, SysLoginLog> implements SysLoginLogService {
}
