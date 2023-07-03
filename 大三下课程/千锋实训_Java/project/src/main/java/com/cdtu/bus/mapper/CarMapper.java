package com.cdtu.bus.mapper;

import com.cdtu.bus.domain.Car;
import com.cdtu.bus.domain.CarVo;

import java.util.List;

/**
 * @Author:千锋强哥
 * @organization: 千锋教研院
 * @Version: 1.0
 */
public interface CarMapper {
    List<Car> queryAllCar(CarVo carVo);

    void addCar(CarVo carVo);

    Car selectByPrimaryKey(String carnumber);

    int deleteByPrimaryKey(String carnumber);

    int updateByPrimaryKeySelective(Car record);
}
