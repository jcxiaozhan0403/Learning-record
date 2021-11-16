package cn.com.huadi.controller;


import cn.com.huadi.entity.Role;
import cn.com.huadi.entity.User;
import cn.com.huadi.service.impl.RoleService;
import cn.com.huadi.service.impl.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import util.ExcludeEmptyQueryWrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
//    1
    @RequestMapping("/toLogin")
    public String longin(String name, String pwd, String role, HttpServletRequest request){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        User user = null;
        Role byId = null;
        queryWrapper
                .eq("name",name)
                .eq("pwd",pwd)
                .eq("role",role);
        try {
            user = userService.getOne(queryWrapper);
            byId = roleService.getById(role);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (user != null){
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            session.setAttribute("role",byId);
        }else {
            return "false";
        }
        return "true";
    };

//    2
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        if ( user != null){
            request.removeAttribute("user");
            request.removeAttribute("role");
        }else {
            return "false";
        }
        return "true";
    }

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
                return "false";
            }
        }
        return "true";
    }
//  11
    @RequestMapping("/getUserList")
    public String getUserList(){
        List<User> list = null;
        try {
            list = userService.list();
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
        return list.toString();
    }

//  12
    @RequestMapping("/deleteUser")
    public String deleteUser(String id){
        try {
            userService.removeById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
        return "true";
    }

//    13
    @RequestMapping("/addUser")
    public String addUser(User user){
        try {
            userService.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
        return "true";
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
            return "false";
        }
        return "true";
    }
}

