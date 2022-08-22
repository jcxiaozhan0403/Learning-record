package com.cheng.service.Impl;

import com.cheng.dao.BillMapper;
import com.cheng.pojo.Bill;
import com.cheng.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    BillMapper billMapper;

    @Override
    public List<Bill> getBillList(){return this.billMapper.getBillList();}
}
