package com.jc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jc.mapper.DeptMapper;
import com.jc.pojo.Dept;
import com.jc.service.DeptService;
import org.springframework.stereotype.Service;

/**
 * @author John.Cena
 * @date 2023/3/18 17:18
 * @Description:
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {
}
