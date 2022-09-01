package cn.com.huadi.controller;

import cn.com.huadi.entity.Collect;
import cn.com.huadi.entity.Curriculum;
import cn.com.huadi.entity.User;
import cn.com.huadi.service.impl.CollectServiceImpl;
import cn.com.huadi.service.impl.CurriculumServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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

    //    17
    @RequestMapping("/addCollect")
    @ResponseBody
    public String addCollect(Collect collect){
        try {
            collectServiceImpl.save(collect);
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
        return "true";
    }

    //    18
    @RequestMapping("/deleteCollect")
    public String deleteCollect(Collect collect, HttpServletRequest request){
        QueryWrapper<Collect> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",collect.getUserId())
                .eq("curriculum_id",collect.getCurriculumId());
        try {
            collectServiceImpl.remove(wrapper);
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }

        User user = (User) request.getSession().getAttribute("user");
        return "redirect:/favorites?userId=" + user.getId();
    }
}

