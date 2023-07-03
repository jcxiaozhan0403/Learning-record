package com.cdtu.bus.service;

import com.cdtu.bus.domain.CustomerVo;
import com.cdtu.sys.utils.DataGridView;

/**
 * @Author:千锋强哥
 * @organization: 千锋教研院
 * @Version: 1.0
 */
public interface ICustomerService {
    DataGridView selectCustomer(CustomerVo customerVo);

    void addCustomer(CustomerVo customerVo);

    void deleteCustomerById(String identity);

    void updateCustomer(CustomerVo customerVo);

    void deleteBatchCustomer(String[] ids);
}
