package cn.com.huadi.controller;

import cn.com.huadi.entity.User;
import cn.com.huadi.service.impl.RoleServiceImpl;
import cn.com.huadi.service.impl.UserServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    @Autowired
    UserServiceImpl userServiceImpl;
    @Autowired
    RoleServiceImpl roleServiceImpl;


    /**
     * 修改密码
     * @param pwd1
     * @param pwd2
     * @param request
     * @return
     */
    @RequestMapping("setPwd")
    public String setPwd(@RequestParam("pwd1") String pwd1,@RequestParam("pwd2") String pwd2, HttpServletRequest request,Model model){
        User user = (User) request.getSession().getAttribute("user");

        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.eq("id",user.getId());

        if (pwd1.equals(user.getPwd())){
            user.setPwd(pwd2);
            try {
                userServiceImpl.update(user,wrapper);
                return "redirect:/login";
            } catch (Exception e) {
                model.addAttribute("msg","修改失败");
                return "/userCenter";
            }
        }else {
            model.addAttribute("msg","修改失败");
            return "/userCenter";
        }
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @RequestMapping("/addUser")
    public String addUser(User user){
        userServiceImpl.save(user);
        return "redirect:/user/list";
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @RequestMapping("/deleteUser")
    public String deleteUser(String id){
        userServiceImpl.removeById(id);
        return "redirect:/user/list";
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    @RequestMapping("/updateUser")
    public String updateUser(User user){
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",user.getId());

        userServiceImpl.update(user,updateWrapper);

        return "redirect:/user/list";
    }

}

