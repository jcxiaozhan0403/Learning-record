package com.process.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jc.model.process.ProcessType;

import java.util.List;

/**
 * @author John.Cena
 * @Description:
 */
public interface ProcessTypeService extends IService<ProcessType> {
    List<ProcessType> findProcessType();
}
