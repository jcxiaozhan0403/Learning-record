package com.cdtu.bus.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.cdtu.bus.domain.Customer;
import com.cdtu.bus.domain.CustomerVo;
import com.cdtu.bus.mapper.CustomerMapper;
import com.cdtu.bus.service.ICustomerService;
import com.cdtu.sys.utils.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author:千锋强哥
 * @organization: 千锋教研院
 * @Version: 1.0
 */
@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerMapper customerMapper;
    /**
     * 分页条件查询客户信息
     * @param customerVo
     * @return
     */
    @Override
    public DataGridView selectCustomer(CustomerVo customerVo) {
        //参数需要传递，当前页码 ,第二个参数是每页现实多少条
        Page<Object> page = PageHelper.startPage(customerVo.getPage(), customerVo.getLimit());
        //做一个可会的全查询
        List<Customer> list =  customerMapper.queryAllCustomer(customerVo);
        //返回分页的结果
        return new DataGridView(page.getTotal(),list);
    }

    /**
     * 添加客户
     * @param customerVo
     */
    @Override
    public void addCustomer(CustomerVo customerVo) {
        customerVo.setCreatetime(new Date());
        customerMapper.addCustomer(customerVo);
    }

    /**
     * 删除
     * @param identity
     */
    @Override
    public void deleteCustomerById(String identity) {
        customerMapper.deleteCustomerById(identity);
    }

    @Override
    public void updateCustomer(CustomerVo customerVo) {
        customerMapper.updateCustomer(customerVo);
    }

    @Override
    public void deleteBatchCustomer(String[] identity) {
        //循环进行删除
        for (String id : identity) {
            deleteCustomerById(id);
        }
    }
}
