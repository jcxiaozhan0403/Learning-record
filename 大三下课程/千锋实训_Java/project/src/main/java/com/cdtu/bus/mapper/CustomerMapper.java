package com.cdtu.bus.mapper;

import com.cdtu.bus.domain.Customer;
import com.cdtu.bus.domain.CustomerVo;

import java.util.List;

public interface CustomerMapper {
    List<Customer> queryAllCustomer(CustomerVo customerVo);

    void insertSelective(CustomerVo customerVo);

    void deleteCustomer(String identity);

    void updateCustomer(CustomerVo customerVo);

    Customer selectByPrimaryKey(String identity);
}
