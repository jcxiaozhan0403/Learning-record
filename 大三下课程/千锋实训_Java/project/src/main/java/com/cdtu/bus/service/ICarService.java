package com.cdtu.bus.service;

import com.cdtu.bus.domain.Car;
import com.cdtu.bus.domain.CarVo;
import com.cdtu.sys.utils.DataGridView;

public interface ICarService {
    DataGridView queryAllCar(CarVo carVo);

    void addCar(CarVo carVo);

    void deleteCar(String carnumber);

    Car queryCarByCarNumber(String carnumber);

    void updateCar(CarVo carVo);

    void deleteBatchCar(String[] ids);
}
