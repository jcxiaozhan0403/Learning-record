package cn.com.huadi.controller;

import cn.com.huadi.entity.User;
import cn.com.huadi.service.impl.RoleService;
import cn.com.huadi.service.impl.UserService;
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
    UserService userService;
    @Autowired
    RoleService roleService;


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
                userService.update(user, updateWrapper);
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
            userService.removeById(id);
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
            userService.save(user);
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
            userService.update(user,updateWrapper);
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
            user = userService.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        model.addAttribute("userInfo",user);
        return "/manager/userEdit";
    }

}

