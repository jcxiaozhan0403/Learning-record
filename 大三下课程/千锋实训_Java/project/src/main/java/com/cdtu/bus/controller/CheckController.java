package com.cdtu.bus.controller;

import com.cdtu.bus.domain.CheckVo;
import com.cdtu.bus.domain.Rent;
import com.cdtu.bus.service.ICheckService;
import com.cdtu.bus.service.IRentService;
import com.cdtu.sys.utils.DataGridView;
import com.cdtu.sys.utils.ResultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("check")
public class CheckController {

    @Autowired
    private IRentService rentService;

    @Autowired
    private ICheckService checkService;

    @PostMapping("checkRentExist")
    public Rent checkRentExist(String rentid){
        //出租单号不存在,返回一个是一个null, 如果存在,返回的是一个rent对象
        return rentService.queryRentByRentId(rentid);
    }

    /**
     * 根据出租单号加载检查单信息
     */
    @PostMapping("initCheckFormData")
    public Map<String,Object> initCheckFormData(String rentid){
        return this.checkService.initCheckFormData(rentid);
    }

    /**
     * 保存检查单
     */
    @PostMapping("saveCheck")
    public ResultObj saveCheck(CheckVo checkVo){
        try {
            checkVo.setCreatetime(new Date());
            checkService.addCheck(checkVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 分页查询所有检查单
     */
    @RequestMapping("loadAllCheck")
    public DataGridView loadAllCheck(CheckVo checkVo){
        return checkService.queryAllCheck(checkVo);
    }

    /**
     * 更新检查单
     */
    @PostMapping("updateCheck")
    public ResultObj updateCheck(CheckVo checkVo){
        try {
            checkService.updateCheck(checkVo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    @RequestMapping("deleteCheck")
    public ResultObj deleteCheck(String checkid){
        try {
            checkService.deleteCheck(checkid);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    @RequestMapping("deleteBatchCheck")
    public ResultObj deleteBatchCheck(CheckVo checkVo){
        try {
            checkService.deleteBatchCheck(checkVo.getIds());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
}
