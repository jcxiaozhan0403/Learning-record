package com.cheng.dao;

import com.cheng.pojo.Pro;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProMapper {
    @Select("select * from smbms.smbms_provider")
    List<Pro> getPro();
}
