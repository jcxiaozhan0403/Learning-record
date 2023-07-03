package com.cdtu.bus.service.impl;

import com.cdtu.sys.utils.AppFileUtils;
import com.cdtu.sys.utils.SysConstant;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.cdtu.bus.domain.Car;
import com.cdtu.bus.domain.CarVo;
import com.cdtu.bus.mapper.CarMapper;
import com.cdtu.bus.service.ICarService;
import com.cdtu.sys.utils.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:千锋强哥
 * @organization: 千锋教研院
 * @Version: 1.0
 */
@Service
public class CarServiceImpl implements ICarService {

    @Autowired
    private CarMapper carMapper;
    /**
     * 车辆的分页查询
     * @param carVo
     * @return
     */
    @Override
    public DataGridView loadAllCar(CarVo carVo) {
        Page<Object> page = PageHelper.startPage(carVo.getPage(), carVo.getLimit());
        //全查询
        List<Car> data = carMapper.queryAllCar(carVo);
        return new DataGridView(page.getTotal(),data);
    }

    @Override
    public void addCar(CarVo carVo) {
        carMapper.addCar(carVo);
    }

    /**
     * 删除一个车辆
     * @param carnumber
     */
    @Override
    public void deleteCar(String carnumber) {
        //先删除图片
        Car car = this.carMapper.selectByPrimaryKey(carnumber);
        //如果不是默认图片就删除
        if (!car.getCarimg().equals(SysConstant.DEFAULT_CAR_IMG)){
            AppFileUtils.deleteFileUsePath(car.getCarimg());
        }
        //删除数据库的数据
        this.carMapper.deleteByPrimaryKey(carnumber);
    }

    @Override
    public Car queryCarByCarNumber(String carnumber) {
        return this.carMapper.selectByPrimaryKey(carnumber);
    }

    /**
     * 更新一个车辆
     * @param carVo
     */
    @Override
    public void updateCar(CarVo carVo) {
        this.carMapper.updateByPrimaryKeySelective(carVo);
    }

    /**
     * 批量删除车辆
     * @param carnumbers
     */
    @Override
    public void deleteBatchCar(String[] carnumbers) {
        for (String carnumber : carnumbers) {
            this.deleteCar(carnumber);
        }
    }
}
