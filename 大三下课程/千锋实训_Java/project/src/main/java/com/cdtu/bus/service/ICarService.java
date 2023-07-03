package com.cdtu.bus.service;

import com.cdtu.bus.domain.Car;
import com.cdtu.bus.domain.CarVo;
import com.cdtu.sys.utils.DataGridView;

/**
 * @Author:千锋强哥
 * @organization: 千锋教研院
 * @Version: 1.0
 */
public interface ICarService {

    /**
     * 分页查询car
     */
    public DataGridView loadAllCar(CarVo carVo);

    void addCar(CarVo carVo);

    /**
     * 根据id删除车辆
     * @param carnumber
     */
    public void deleteCar(String carnumber);

    /**
     * 根据车牌号查询
     * @param carnumber
     * @return
     */
    Car queryCarByCarNumber(String carnumber);

    /**
     * 修改车辆
     * @param carVo
     */
    public void updateCar(CarVo carVo);

    /**
     * 批量删除车辆
     * @param carnumbers
     */
    public void deleteBatchCar(String[] carnumbers);
}
