package cn.com.huadi.controller;

import cn.com.huadi.entity.Collect;
import cn.com.huadi.entity.Curriculum;
import cn.com.huadi.entity.User;
import cn.com.huadi.service.impl.CollectService;
import cn.com.huadi.service.impl.CurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import util.ExcludeEmptyQueryWrapper;

import javax.servlet.http.HttpServletRequest;
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
@Controller
public class CollectController {
    @Autowired
    CollectService collectService;
    @Autowired
    CurriculumService curriculumService;
//    9
    @RequestMapping("/getCollect")
    public List<Curriculum> getCollect(String userId){
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
            return null;
        }

        return curricula;
    }

    //    17
    @RequestMapping("/addCollect")
    @ResponseBody
    public String addCollect(Collect collect){
        try {
            collectService.save(collect);
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
        return "true";
    }

    //    18
    @RequestMapping("/deleteCollect")
    public String deleteCollect(Collect collect, HttpServletRequest request){
        ExcludeEmptyQueryWrapper<Collect> wrapper = new ExcludeEmptyQueryWrapper<>();
        wrapper.eq("user_id",collect.getUserId())
                .eq("curriculum_id",collect.getCurriculumId());
        try {
            collectService.remove(wrapper);
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }

        User user = (User) request.getSession().getAttribute("user");
        return "redirect:/favorites?userId=" + user.getId();
    }
}

