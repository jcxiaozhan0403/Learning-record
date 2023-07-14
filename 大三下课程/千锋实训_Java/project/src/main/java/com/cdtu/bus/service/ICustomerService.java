package com.cdtu.bus.service;

import com.cdtu.bus.domain.Customer;
import com.cdtu.bus.domain.CustomerVo;
import com.cdtu.sys.utils.DataGridView;

public interface ICustomerService {
    DataGridView selectCustomer(CustomerVo customerVo);

    void addCustomer(CustomerVo customerVo);

    void deleteCustomerById(String identity);

    void updateCustomer(CustomerVo customerVo);

    void deleteBatchCustomer(String[] ids);

    Customer queryCustomerByIdentity(String identity);
}
