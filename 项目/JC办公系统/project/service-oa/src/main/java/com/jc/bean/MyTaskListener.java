package com.jc.bean;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 * @author John.Cena
 * @date 2023/4/12 17:13
 * @Description:
 */
public class MyTaskListener implements TaskListener {

    @Override
    public void notify(DelegateTask delegateTask) {
        if(delegateTask.getName().equals("张三审批")){
            //这里指定任务负责人
            delegateTask.setAssignee("zhangsan");
        } else if(delegateTask.getName().equals("李四审批")){
            //这里指定任务负责人
            delegateTask.setAssignee("lisi");
        }
    }
}
