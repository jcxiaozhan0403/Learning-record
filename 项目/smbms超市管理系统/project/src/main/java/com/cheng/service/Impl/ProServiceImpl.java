package com.cheng.service.Impl;

import com.cheng.dao.ProMapper;
import com.cheng.pojo.Pro;
import com.cheng.service.ProService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProServiceImpl implements ProService {
    @Autowired
    ProMapper proMapper;

    @Override
    public List<Pro> getPro(){return this.proMapper.getPro();}
}
