package com.process.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jc.model.process.ProcessRecord;

/**
 * @author John.Cena
 * @Description:
 */
public interface ProcessRecordService extends IService<ProcessRecord> {

    void record(Long processId, Integer status, String description);

}
