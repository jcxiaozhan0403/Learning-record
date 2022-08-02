package com.cheng.dao;

import com.cheng.pojo.Bill;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BillMapper {

    @Select("select * from smbms.smbms_bill")
    List<Bill> getBillList();
}
