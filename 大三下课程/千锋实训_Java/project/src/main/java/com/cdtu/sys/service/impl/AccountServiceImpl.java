package com.cdtu.sys.service.impl;

import com.cdtu.sys.mapper.AccountMapper;
import com.cdtu.sys.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional  //事务控制
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountMapper mapper;

    @Override
    public int updateTransfer(String inName, String outName, double money) {
        try {
            //调用转入
            mapper.transferIn(inName,money);
            //调用转出操作
            mapper.transferOut(outName,money);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
