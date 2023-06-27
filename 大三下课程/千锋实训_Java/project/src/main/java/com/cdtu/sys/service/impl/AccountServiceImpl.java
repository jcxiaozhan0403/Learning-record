package com.cdtu.sys.service.impl;

import com.cdtu.sys.mapper.AccountMapper;
import com.cdtu.sys.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author:千锋强哥
 * @organization: 千锋教研院
 * @Version: 1.0
 */
@Service
@Transactional
public class AccountServiceImpl implements IAccountService {

    /**
     * 注入的AccountMapper接口的子类代理对象
     */
    @Autowired
    private AccountMapper accountMapper;

    /**
     * 转账的测试方法
     * @param inName
     * @param outName
     * @param money
     * @return
     */
    @Override
    public int updateTransfer(String inName, String outName, double money) {

        try {
            accountMapper.transferIn(inName,money);
            accountMapper.transferOut(outName,money);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }
}
