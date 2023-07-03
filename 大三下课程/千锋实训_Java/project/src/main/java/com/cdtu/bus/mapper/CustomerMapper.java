package com.cdtu.bus.mapper;

import com.cdtu.bus.domain.Customer;
import com.cdtu.bus.domain.CustomerVo;

import java.util.List;

/**
 * @Author:千锋强哥
 * @organization: 千锋教研院
 * @Version: 1.0
 */
public interface CustomerMapper {

    List<Customer> queryAllCustomer(CustomerVo customerVo);

    void addCustomer(CustomerVo customerVo);

    void deleteCustomerById(String identity);

    void updateCustomer(CustomerVo customerVo);
}
