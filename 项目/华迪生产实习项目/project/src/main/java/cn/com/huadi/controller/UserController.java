package cn.com.huadi.controller;

import cn.com.huadi.entity.User;
import cn.com.huadi.service.impl.RoleServiceImpl;
import cn.com.huadi.service.impl.UserServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yuan点
 * @since 2021-11-06
 */
@Controller
public class UserController {
    @Autowired
    UserServiceImpl userServiceImpl;
    @Autowired
    RoleServiceImpl roleServiceImpl;


//    10
    @RequestMapping("setPwd")
    public String setPwd(String pwd1,String pwd2,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        boolean equals = pwd1.equals(user.getPwd());

        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",user.getId());
        if (equals){
            user.setPwd(pwd2);
            try {
                userServiceImpl.update(user, updateWrapper);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return "redirect:/logout";
    }

//  12
    @RequestMapping("/deleteUser")
    public String deleteUser(String id){
        try {
            userServiceImpl.removeById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return "redirect:/user/list";
    }

//    13
    @RequestMapping("/addUser")
    public String addUser(User user){
        try {
            userServiceImpl.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return "redirect:/user/list";
    }

//    14
    @RequestMapping("/updateUser")
    public String updateUser(User user){
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",user.getId());
        try {
            userServiceImpl.update(user,updateWrapper);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return "redirect:/user/list";
    }

    /**
     * 跳转到用户修改界面
     * @param
     * @return
     * @Description
     */
    @RequestMapping("/user/edit")
    public String getUserById(String id, Model model){
        User user = null;
        try {
            user = userServiceImpl.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        model.addAttribute("userInfo",user);
        return "/manager/userEdit";
    }

}

