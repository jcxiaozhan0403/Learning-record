package com.cdtu.bus.service;

import com.cdtu.bus.domain.CheckVo;
import com.cdtu.sys.utils.DataGridView;

import java.util.Map;

public interface ICheckService {

    Map<String,Object> initCheckFormData(String rentid);

    void addCheck(CheckVo checkVo);

    DataGridView queryAllCheck(CheckVo checkVo);

    void updateCheck(CheckVo checkVo);

    void deleteCheck(String checkid);

    void deleteBatchCheck(String[] ids);
}
