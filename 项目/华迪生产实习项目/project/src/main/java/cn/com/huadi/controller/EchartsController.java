package cn.com.huadi.controller;

import cn.com.huadi.entity.Collect;
import cn.com.huadi.entity.Mycourse;
import cn.com.huadi.service.impl.CollectServiceImpl;
import cn.com.huadi.service.impl.CurriculumServiceImpl;
import cn.com.huadi.service.impl.MycourseServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author John.Cena
 * @date 2022/9/2 21:40
 * @Description:
 */
@RestController
public class EchartsController {
    @Autowired
    CurriculumServiceImpl curriculumServiceImpl;
    @Autowired
    MycourseServiceImpl mycourseServiceImpl;
    @Autowired
    CollectServiceImpl collectServiceImpl;

    @RequestMapping("/getData")
    public List<Object> getData(@RequestParam("userId") int userId){
        int myCourseNum = 0;
        int collectNum = 0;
        int totleNum = 0;

        //查询我的课程数量
        QueryWrapper<Mycourse> wrapper = new QueryWrapper<>();
        wrapper
                .select("distinct curriculum_id")
                .eq("user_id",userId);
        myCourseNum = mycourseServiceImpl.list(wrapper).size();

        //查询收藏课程数量
        QueryWrapper<Collect> wrapper2 = new QueryWrapper<>();
        wrapper
                .select("distinct curriculum_id")
                .eq("user_id",userId);
        collectNum = collectServiceImpl.list(wrapper2).size();

        //查询课程总数
        totleNum = curriculumServiceImpl.count();

        List<Object> list = new ArrayList<>();
        list.add("概况统计");
        list.add(myCourseNum);
        list.add(collectNum);
        list.add(totleNum);

        return list;
    }
}
