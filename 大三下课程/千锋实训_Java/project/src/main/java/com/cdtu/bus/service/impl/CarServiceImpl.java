package com.cdtu.bus.service.impl;

import com.cdtu.bus.domain.Car;
import com.cdtu.bus.domain.CarVo;
import com.cdtu.bus.mapper.CarMapper;
import com.cdtu.bus.service.ICarService;
import com.cdtu.sys.utils.AppFileUtils;
import com.cdtu.sys.utils.DataGridView;
import com.cdtu.sys.utils.SysConstant;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements ICarService {


    @Autowired
    private CarMapper carMapper;

    @Override
    public DataGridView queryAllCar(CarVo carVo) {
        //使用PageHelper的分页查询
        Page<Car> page = PageHelper.startPage(carVo.getPage(),carVo.getLimit());
        List<Car> data = carMapper.queryAllCar(carVo);
        return new DataGridView(page.getTotal(),data);
    }

    @Override
    public void addCar(CarVo carVo) {
        this.carMapper.insertSelective(carVo);
    }

    /**
     * 删除车辆的方法
     * @param carnumber
     */
    @Override
    public void deleteCar(String carnumber) {
        //先删除图片
        Car car = carMapper.selectByPrimaryKey(carnumber);
        //如果不是默认图片,就进行删除
        if(!car.getCarimg().equals(SysConstant.DEFAULT_CAR_IMG)){
            AppFileUtils.deleteFileUsePath(car.getCarimg());
        }
        //删除数据库数据
        carMapper.deleteByPrimaryKey(carnumber);
    }

    @Override
    public Car queryCarByCarNumber(String carnumber) {
        return carMapper.selectByPrimaryKey(carnumber);
    }

    @Override
    public void updateCar(CarVo carVo) {
        carMapper.updateByPrimaryKeySelective(carVo);
    }

    @Override
    public void deleteBatchCar(String[] carnumbers) {
        for(String carnumber : carnumbers){
            this.deleteCar(carnumber);
        }
    }
}
