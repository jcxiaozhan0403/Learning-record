package com.cdtu.bus.service.impl;

import com.cdtu.bus.domain.CarVo;
import com.cdtu.bus.domain.Rent;
import com.cdtu.bus.domain.RentVo;
import com.cdtu.bus.mapper.CarMapper;
import com.cdtu.bus.mapper.RentMapper;
import com.cdtu.bus.service.IRentService;
import com.cdtu.sys.utils.DataGridView;
import com.cdtu.sys.utils.SysConstant;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentServiceImpl implements IRentService {

    @Autowired
    private RentMapper rentMapper;

    @Autowired
    private CarMapper carMapper;

    @Override
    public void addRent(RentVo rentVo) {
        this.rentMapper.insertSelective(rentVo);
        //更改车辆的出租信息
        CarVo vo  = new CarVo();
        vo.setCarnumber(rentVo.getCarnumber());
        //设置车辆的状态为已出租
        vo.setIsrenting(SysConstant.RENT_BACK_TRUE);
        carMapper.updateByPrimaryKeySelective(vo);
    }

    /**
     * 分页查询出租单
     * @param rentVo
     * @return
     */
    @Override
    public DataGridView queryAllRent(RentVo rentVo) {
        Page<Rent> page = PageHelper.startPage(rentVo.getPage(),rentVo.getLimit());
        //做全查询
        List<Rent> data = rentMapper.queryAllRent(rentVo);
        return new DataGridView(page.getTotal(),data);
    }

    @Override
    public void updateRent(RentVo rentVo) {
        rentMapper.updateByPrimaryKeySelective(rentVo);
    }

    @Override
    public void deleteRent(RentVo rentVo) {
        CarVo carvo = new CarVo();
        carvo.setCarnumber(rentVo.getCarnumber());
        carvo.setIsrenting(SysConstant.RENT_CAR_FALSE); //车辆为出租状态
        //删除出租单
        rentMapper.deleteByPrimaryKey(rentVo.getRentid());
        //更新车辆的状态
        carMapper.updateByPrimaryKeySelective(carvo);
    }

    @Override
    public Rent queryRentByRentId(String rentid) {
        return   rentMapper.queryRentById(rentid);
    }

}
