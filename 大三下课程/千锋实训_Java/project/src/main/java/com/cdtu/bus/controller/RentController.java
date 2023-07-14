package com.cdtu.bus.controller;

import com.cdtu.bus.domain.Customer;
import com.cdtu.bus.domain.RentVo;
import com.cdtu.bus.service.ICustomerService;
import com.cdtu.bus.service.IRentService;
import com.cdtu.sys.domain.User;
import com.cdtu.sys.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("rent")
public class RentController {

    @Autowired
    private IRentService rentService;

    @Autowired
    private ICustomerService customerService;

    /**
     * 检查客户身份证是否存在
     */
    @RequestMapping("checkCustomerExit")
    public ResultObj checkCustomerExit(RentVo rentVo){
        Customer customer =  customerService.queryCustomerByIdentity(rentVo.getIdentity());
        //判断该客户是否存在
        if(customer != null){
            return ResultObj.STATUS_TRUE;
        }else {
            return ResultObj.STATUS_FALSE;
        }
    }

    /**
     * 初始化添加出租单的方法
     */
    @RequestMapping("initRentFrom")
    public RentVo initRentFrom(RentVo rentVo){
        //生成出租单
        rentVo.setRentid(RandomUtils.createRandomStringUseTime(SysConstant.CAR_ORDER_CZ));
        //设置起租时间
        rentVo.setBegindate(new Date());
        //设置操作员
        User user = (User) WebUtils.getHttpSession().getAttribute("user");
        rentVo.setOpername(user.getRealname());
        return rentVo;
    }


    /**
     * 保存出租
     */
    @PostMapping("saveRent")
    public ResultObj saveRent(RentVo rentVo){
        try {
            //设置归还的状态
            rentVo.setRentflag(SysConstant.RENT_BACK_FALSE);
            //设置创建的时间
            rentVo.setCreatetime(new Date());
            //保存操作
            this.rentService.addRent(rentVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 查询出租单
     */
    @RequestMapping("loadAllRent")
    public DataGridView loadAllRent(RentVo rentVo){
        return rentService.queryAllRent(rentVo);
    }



    /**
     * 修改出租单
     */
    @RequestMapping("updateRent")
    public ResultObj updateRent(RentVo rentVo){
        try {
            rentService.updateRent(rentVo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    /**
     * 删除出租单
     */
    @RequestMapping("deleteRent")
    public ResultObj deleteRent(RentVo rentVo){
        try {
            rentService.deleteRent(rentVo);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
}
