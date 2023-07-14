package com.cdtu.bus.mapper;

import com.cdtu.bus.domain.Rent;
import com.cdtu.bus.domain.RentVo;

import java.util.List;

public interface RentMapper {
    void insertSelective(RentVo rentVo);

    List<Rent> queryAllRent(RentVo rentVo);

    void updateByPrimaryKeySelective(RentVo rentVo);

    void deleteByPrimaryKey(String rentid);

    Rent queryRentById(String rentid);
}
