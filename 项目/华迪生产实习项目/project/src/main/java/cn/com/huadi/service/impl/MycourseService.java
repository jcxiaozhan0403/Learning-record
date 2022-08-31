package cn.com.huadi.service.impl;

import cn.com.huadi.entity.Mycourse;
import cn.com.huadi.mapper.MycourseMapper;
import cn.com.huadi.service.IMycourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class MycourseService extends ServiceImpl<MycourseMapper, Mycourse> implements IMycourseService {

}
