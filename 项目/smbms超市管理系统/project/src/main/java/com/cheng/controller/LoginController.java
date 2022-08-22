package com.cheng.controller;

import com.cheng.pojo.Role;
import com.cheng.pojo.User;
import com.cheng.service.UserService;
import com.cheng.tools.PageSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping("login.do")
    public String Login(String userCode, String userPassword, Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int flag = 0;
        String msg = "";
        if(userCode.equals("") || userCode.equals(null) || userPassword.equals("") || userPassword.equals(null)){
            msg="error";
        }else {
            User user = this.userService.getUser(userCode.trim());
            if(user!=null){
                    if(userPassword.equals(user.getUserPassword())){
                        HttpSession session = request.getSession();
                        session.setAttribute("user", user);
                        flag = 1;
                        msg = "OK";
                        return "jsp/frame";
                    }else{
                        flag = 0;
                        msg = "用户名或密码不正确";
                    }
                }else{
                flag = 0;
                msg = "user null";
            }
        }
        model.addAttribute("error",msg);
        request.setAttribute("error","错误");
        request.getRequestDispatcher("login.jsp").forward(request,response);
        return "jsp/logintext";
    }

    @RequestMapping("logout")
    public String logout(HttpServletRequest request){

        HttpSession session = request.getSession();
        session.removeAttribute("user");

        return "redirect:/login.jsp";
    }

    @RequestMapping("pwdmodify")
    public String pwdmodify(){
        return "jsp/pwdmodify";
    }

    //修改密码
    @RequestMapping("user.do")
    public String pwd(@RequestParam("oldpassword")String oldpassword, @RequestParam("newpassword") String newpassword, HttpServletRequest request,Model model){
        int flag=0;
        HttpSession session = request.getSession();
        User sysuser = (User) session.getAttribute("user");
        if (sysuser != null){
            User user = this.userService.getUser(sysuser.getUserCode());
            flag = this.userService.updatePwd(user.getUserCode(),newpassword);
            model.addAttribute("message","ok");
        }else {
            flag=0;
            model.addAttribute("message","失败");
        }
        return "jsp/pwdmodify";
    }

    //旧密码验证
    @RequestMapping("check")
    @ResponseBody
    public Map<String, Object> check(String oldpassword , HttpServletRequest request){
        String result="";
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (session==null){
            result="sessionerror";
        }else if (oldpassword==null){
            result="error";
        }else if (user.getUserPassword().equals(oldpassword)){
            result="true";
        }else {
            result="false";
        }
        Map<String, Object> mapMode = new HashMap<String, Object>();
        mapMode.put("result", result);
        return mapMode;
    }

    //用户管理
    @RequestMapping("query")
    public String query(HttpServletRequest request,Model model) throws UnsupportedEncodingException {
        //从前端获取数据
        String queryUserName = request.getParameter("queryname");
        System.out.println(queryUserName);
        String temp = request.getParameter("queryUserRole");
        String pageIndex = request.getParameter("pageIndex");
        int queryUserRole = 0;

        //获取用户列表
        int pageSize = 5;
        int currentPageNo = 1;

        if (queryUserName == null){
            queryUserName = "";
        }

        if (temp!=null && !temp.equals("")){
            queryUserRole = Integer.parseInt(temp);
        }

        if (pageIndex!=null){
            currentPageNo = Integer.parseInt(pageIndex);
        }


        //获取用户总数
        int totalCount = userService.getUserCount(queryUserName,queryUserRole);
        //总页数
        PageSupport pageSupport = new PageSupport();
        pageSupport.setCurrentPageNo(currentPageNo);
        pageSupport.setPageSize(pageSize);
        pageSupport.setTotalCount(totalCount);

        int totalPageCount = pageSupport.getTotalPageCount();

        //控制首页和尾页
        if (currentPageNo<1){
            currentPageNo = 1;
        }else if (currentPageNo > totalPageCount){
            currentPageNo = totalPageCount;
        }


        //获取用户列表展示
        List<User> userList = null;
        try {
//            currentPageNo = (currentPageNo-1)*pageSize;
//            System.out.println("currentPageNo   "+currentPageNo);
            userList = userService.getUserList(queryUserName,queryUserRole,(currentPageNo-1)*pageSize,pageSize);
            System.out.println(userList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Role> roleList = userService.getRoleList();
        model.addAttribute("userList",userList);
        model.addAttribute("roleList",roleList);
        model.addAttribute("totalPageCount",totalPageCount);
        model.addAttribute("totalCount",totalCount);
        model.addAttribute("currentPageNo",currentPageNo);
        model.addAttribute("queryUserName",queryUserName);
        model.addAttribute("queryUserRole",queryUserRole);
        return "jsp/userlist";
    }

    @RequestMapping("add.do")
    public String toAdd(){
        return "jsp/useradd";
    }

    @RequestMapping("add")
    public String Add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("add()================");
        String userCode = request.getParameter("userCode");
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("birthday");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String userRole = request.getParameter("userRole");

        User user = new User();
        user.setUserCode(userCode);
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        user.setAddress(address);
        try {
            user.setBirthday( new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        user.setGender(Integer.valueOf(gender));
        user.setPhone(phone);
        user.setUserRole(Integer.valueOf(userRole));
        user.setCreationDate(new Date());
        user.setCreatedBy(((User)request.getSession().getAttribute("user")).getId());
        if (userService.addUser(user)>0){
            return "redirect:query";
        }else {
            return "jsp/useradd";
        }
    }

    @RequestMapping("deluser")
    @ResponseBody
    public Map<String,String> deluser(String uid){
        Integer delId = 0;
        try{
            delId = Integer.parseInt(uid);
        }catch (Exception e) {
            // TODO: handle exception
            delId = 0;
        }
        HashMap<String, String> resultMap = new HashMap<String, String>();
        if(delId <= 0){
            resultMap.put("delResult", "notexist");
        }else{
            if(userService.deleteUserById(delId)>0){
                resultMap.put("delResult", "true");
            }else{
                resultMap.put("delResult", "false");
            }
        }
        return resultMap;
    }

    @RequestMapping("view")
    public String view(String uid,Model model,HttpServletRequest request,HttpServletResponse response){
        User user = userService.getUser(uid);
        model.addAttribute("user", user);
      return "jsp/userview";
    }

    @RequestMapping("modify.do")
    public String modifydo(String method,String uid,Model model){
        User user = userService.getUser(uid);
        model.addAttribute("user", user);
        return "jsp/usermodify";
    }

    @RequestMapping("modifyexe")
    public String modify(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        String id = request.getParameter("uid");
        String userName = request.getParameter("userName");
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("birthday");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String userRole = request.getParameter("userRole");

        User user = new User();
        user.setId(Integer.valueOf(id));
        user.setUserName(userName);
        user.setGender(Integer.valueOf(gender));
        try {
            user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        user.setPhone(phone);
        user.setAddress(address);
        user.setUserRole(Integer.valueOf(userRole));
        user.setModifyBy(((User)request.getSession().getAttribute("user")).getId());
        user.setModifyDate(new Date());

        if(userService.modify(user)>0){
            return "redirect:query";
        }
        return "jsp/usermodify";
    }

    @RequestMapping("getrolelist")
    @ResponseBody
    public List<Role> getrolelist(){
        List<Role> roleList = userService.getRoleList();
//        Map<String, Object> mapMode = new HashMap<String, Object>();
//        mapMode.put("roleList", roleList);
        return roleList;
    }

    @RequestMapping("ucexist")
    @ResponseBody
    public Map<String, String> ucexist(HttpServletRequest request) {
        String userCode = request.getParameter("userCode");

        HashMap<String, String> resultMap = new HashMap<String, String>();
        if (userCode == null || userCode.equals("")) {
            //userCode == null || userCode.equals("")
            resultMap.put("userCode", "exist");
        } else {
            User user = userService.getUser(userCode);
            if (null != user) {
                resultMap.put("userCode", "exist");
            } else {
                resultMap.put("userCode", "notexist");
            }
        }
        return resultMap;
    }

    @RequestMapping("/main")
    public String main(HttpSession session, Model model){
        System.out.println(session.getAttribute(session.getAttributeNames().nextElement().toString()));
        model.addAttribute("username",session.getAttributeNames().nextElement().toString());
        return "main";
    }

    @RequestMapping("/gologintext")
    public String logintext(){
        return "logintext";
    }

    @RequestMapping("/logintext")
    public String login(HttpSession session, String username, String password, Model model){
        System.out.println("数据提交");
        session.setAttribute("userLoginInfo",username);
//        return "redirect:/book/allBook";
        model.addAttribute("username",username);
        return "main";
    }

    @RequestMapping("/goOut")
    public String goOut(HttpSession session){
        System.out.println("销毁");
        session.removeAttribute("userLoginInfo");
//        return "redirect:/book/allBook";

        return "logintext";
    }

}
