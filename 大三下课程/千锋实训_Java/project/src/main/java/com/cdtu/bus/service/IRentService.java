package com.cdtu.bus.service;

import com.cdtu.bus.domain.Rent;
import com.cdtu.bus.domain.RentVo;
import com.cdtu.sys.utils.DataGridView;

public interface IRentService {
    void addRent(RentVo rentVo);

    DataGridView queryAllRent(RentVo rentVo);

    void updateRent(RentVo rentVo);

    void deleteRent(RentVo rentVo);

    Rent queryRentByRentId(String rentid);
}
