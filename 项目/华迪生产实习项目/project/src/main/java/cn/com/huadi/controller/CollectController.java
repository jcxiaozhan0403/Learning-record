package cn.com.huadi.controller;


import cn.com.huadi.entity.Collect;
import cn.com.huadi.entity.Curriculum;
import cn.com.huadi.service.impl.CollectService;
import cn.com.huadi.service.impl.CurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import util.ExcludeEmptyQueryWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yuan点
 * @since 2021-11-06
 */
@RestController
public class CollectController {
    @Autowired
    CollectService collectService;
    @Autowired
    CurriculumService curriculumService;
//    9
    @RequestMapping("/getCollect")
    public String getCollect(String userId){
        ExcludeEmptyQueryWrapper<Collect> queryWrapper = new ExcludeEmptyQueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        ArrayList<Curriculum> curricula = null;
        try {
            List<Collect> list = collectService.list(queryWrapper);
            curricula = new ArrayList<>();
            for (Collect collect : list) {
                curricula.add(curriculumService.getById(collect.getCurriculumId()));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }

        return curricula.toString();
    }
}

