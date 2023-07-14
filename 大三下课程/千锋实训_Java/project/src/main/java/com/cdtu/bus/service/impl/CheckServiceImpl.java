package com.cdtu.bus.service.impl;

import com.cdtu.bus.domain.*;
import com.cdtu.bus.mapper.CarMapper;
import com.cdtu.bus.mapper.CheckMapper;
import com.cdtu.bus.mapper.CustomerMapper;
import com.cdtu.bus.mapper.RentMapper;
import com.cdtu.bus.service.ICheckService;
import com.cdtu.sys.domain.User;
import com.cdtu.sys.utils.DataGridView;
import com.cdtu.sys.utils.RandomUtils;
import com.cdtu.sys.utils.SysConstant;
import com.cdtu.sys.utils.WebUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CheckServiceImpl implements ICheckService {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private RentMapper rentMapper;

    @Autowired
    private CarMapper carMapper;

    @Autowired
    private CheckMapper checkMapper;

    @Override
    public Map<String, Object> initCheckFormData(String rentid) {
        //查询出租单
        Rent rent = rentMapper.queryRentById(rentid);
        //查询客户信息
        Customer customer = customerMapper.selectByPrimaryKey(rent.getIdentity());
        //查询车辆
        Car car = carMapper.selectByPrimaryKey(rent.getCarnumber());
        //组装check对象
        Check check = new Check();
        check.setCheckid(RandomUtils.createRandomStringUseTime(SysConstant.CAR_ORDER_JC));
        check.setRentid(rentid);
        check.setCheckdate(new Date());
        User user = (User) WebUtils.getHttpSession().getAttribute("user");
        check.setOpername(user.getRealname());
        //数据组装
        Map<String,Object> map = new HashMap<>();
        map.put("rent",rent);
        map.put("customer",customer);
        map.put("car",car);
        map.put("check",check);
        return map;
    }

    /**
     * 保存检查单
     * @param checkVo
     */
    @Override
    public void addCheck(CheckVo checkVo) {
        //保存检查单
        checkMapper.insertSelective(checkVo);

        //更改出租状态
        Rent rent = rentMapper.queryRentById(checkVo.getRentid());
        //更改状态为已归还
        RentVo rentVo = new RentVo();
        rentVo.setRentid(rent.getRentid());
        rentVo.setRentflag(SysConstant.RENT_BACK_TRUE);
        rentMapper.updateByPrimaryKeySelective(rentVo);

        //更改汽车的状态
        Car car = carMapper.selectByPrimaryKey(rent.getCarnumber());
        //更改汽车状态为未出租
        CarVo carVo = new CarVo();
        carVo.setCarnumber(car.getCarnumber());
        carVo.setIsrenting(SysConstant.RENT_CAR_FALSE);
        carMapper.updateByPrimaryKeySelective(carVo);

    }

    @Override
    public DataGridView queryAllCheck(CheckVo checkVo) {
        Page<Object> page = PageHelper.startPage(checkVo.getPage(),checkVo.getLimit());
        List<Check> data = checkMapper.queryAllCheck(checkVo);
        return new DataGridView(page.getTotal(),data);
    }

    @Override
    public void updateCheck(CheckVo checkVo) {
        checkMapper.updateByPrimaryKeySelective(checkVo);
    }

    @Override
    public void deleteCheck(String checkid) {
        checkMapper.deleteByPrimaryKey(checkid);
    }

    @Override
    public void deleteBatchCheck(String[] ids) {
        for(String id : ids){
            checkMapper.deleteByPrimaryKey(id);
        }
    }
}
