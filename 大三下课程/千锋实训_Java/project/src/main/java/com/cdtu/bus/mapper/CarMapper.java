package com.cdtu.bus.mapper;

import com.cdtu.bus.domain.Car;
import com.cdtu.bus.domain.CarVo;

import java.util.List;

public interface CarMapper {
    List<Car> queryAllCar(CarVo carVo);

    void insertSelective(CarVo carVo);

    Car selectByPrimaryKey(String carnumber);

    void deleteByPrimaryKey(String carnumber);

    void updateByPrimaryKeySelective(CarVo carVo);
}
