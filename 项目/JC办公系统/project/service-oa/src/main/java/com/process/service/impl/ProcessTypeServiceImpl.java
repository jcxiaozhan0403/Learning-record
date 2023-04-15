package com.process.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jc.model.process.ProcessTemplate;
import com.jc.model.process.ProcessType;
import com.process.mapper.ProcessTypeMapper;
import com.process.service.ProcessTemplateService;
import com.process.service.ProcessTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author John.Cena
 * @date 2023/4/13 11:07
 * @Description:
 */
@Service
@SuppressWarnings({"unchecked", "rawtypes"})
public class ProcessTypeServiceImpl extends ServiceImpl<ProcessTypeMapper, ProcessType> implements ProcessTypeService {

    @Autowired
    private ProcessTemplateService processTemplateService;

    @Override
    public List<ProcessType> findProcessType() {
        //1 查询所有审批类型，返回list集合
        List<ProcessType> processTypeList = baseMapper.selectList(null);

        //2 遍历返回所有审批类型list集合
        for (ProcessType processType:processTypeList) {
            //3 遍历审批类型的id，查询各自审批模板
            Long typeId = processType.getId();
            //根据审批分类id查询对应审批模板列表
            LambdaQueryWrapper<ProcessTemplate> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(ProcessTemplate::getProcessTypeId,typeId);
            List<ProcessTemplate> processTemplateList = processTemplateService.list(wrapper);

            //4 ProcessType有一个字段就是用来存放模板列表的
            processType.setProcessTemplateList(processTemplateList);
        }
        return processTypeList;
    }
}
