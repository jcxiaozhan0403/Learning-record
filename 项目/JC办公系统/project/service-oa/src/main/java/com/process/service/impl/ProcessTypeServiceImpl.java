package com.process.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jc.model.process.ProcessType;
import com.process.mapper.ProcessTypeMapper;
import com.process.service.ProcessTypeService;
import org.springframework.stereotype.Service;

/**
 * @author John.Cena
 * @date 2023/4/13 11:07
 * @Description:
 */
@Service
@SuppressWarnings({"unchecked", "rawtypes"})
public class ProcessTypeServiceImpl extends ServiceImpl<ProcessTypeMapper, ProcessType> implements ProcessTypeService {

}
