package cn.com.huadi.controller;

import cn.com.huadi.entity.Collect;
import cn.com.huadi.entity.Curriculum;
import cn.com.huadi.service.impl.CollectServiceImpl;
import cn.com.huadi.service.impl.CurriculumServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CollectController {
    @Autowired
    CollectServiceImpl collectServiceImpl;
    @Autowired
    CurriculumServiceImpl curriculumServiceImpl;

    /**
     * 根据用户id查询收藏列表
     * @param userId
     * @return
     */
    @RequestMapping("/getCollect")
    public List<Curriculum> getCollect(String userId){
        QueryWrapper<Collect> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        List<Collect> list = collectServiceImpl.list(queryWrapper);

        List<Curriculum> curricula = new ArrayList<>();

        for (Collect collect : list) {
            curricula.add(curriculumServiceImpl.getById(collect.getCurriculumId()));
        }

        return curricula;
    }

    /**
     * 收藏课程
     * @param collect
     * @return
     */
    @RequestMapping("/addCollect")
    @ResponseBody
    public String addCollect(Collect collect){
        collectServiceImpl.save(collect);
        return "true";
    }

    /**
     * 取消收藏课程
     * @param collect
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteCollect")
    public String deleteCollect(Collect collect){
        QueryWrapper<Collect> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",collect.getUserId())
                .eq("curriculum_id",collect.getCurriculumId());

        collectServiceImpl.remove(wrapper);
        return "true";
    }
}

