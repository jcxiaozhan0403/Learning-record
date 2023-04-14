package com.process.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jc.model.process.ProcessRecord;

/**
 * @author John.Cena
 * @date 2023/4/14 21:32
 * @Description:
 */
public interface ProcessRecordService extends IService<ProcessRecord> {

    void record(Long processId, Integer status, String description);

}
