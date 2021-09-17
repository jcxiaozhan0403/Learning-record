package com.huadi.controller;


import com.huadi.pojo.Order;
import com.huadi.pojo.User;
import com.huadi.service.UserService;
import com.huadi.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping(value = "/user") //主入口
public class UserController {

//    UserService userService = new UserServiceImpl() ;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")//打开登录页面
    public String register(){
         return "user/login";
    }

        /*
        路径绑定
         */
    @RequestMapping(value = "/doLogin/{userId}" ,method = RequestMethod.GET)
    public String login(@PathVariable("userId") int userid){
        System.out.println("userid = "+userid);
        return "user/success";
    }

         /*
         获取订单列表
          */
    @RequestMapping(value = "/doLogin2")
    public String login2(User user, ModelMap modelMap, HttpServletRequest request){
        HttpSession httpSession = request.getSession(); //获取当前服务器的session对象
        httpSession.setAttribute("UserSession",user);
        httpSession.setMaxInactiveInterval(5*60*1000);
        boolean result = userService.getLoginUser(user);
        if(result){
            List<Order> orderList = userService.getOrderList();
            System.out.println(orderList);
            modelMap.addAttribute("orderList",orderList);
            return "user/success";
        }

        return "user/fail";
    }

    /*
     打开修改页面
     */
    @RequestMapping(value = "/update/{orderId}")
    public String updateOrder(@PathVariable("orderId")int orderId,
                              ModelMap modelMap) throws SQLException {
        System.out.println("orderId:"+orderId);
       Order order =  userService.getOrder(orderId);
       modelMap.addAttribute("order",order);
       return "user/update";
    }

    /*
    修改执行
     */
    @RequestMapping(value = "/doUpdate",method = RequestMethod.POST)
    @ResponseBody
    public String doUpdate(@RequestBody Order order)  {
        boolean result = userService.updateOrder(order);
        if(result){
            return "修改成功！";
        }
        return "修改失败";
    }
    /*
    删除执行
     */
    @RequestMapping(value = "/doDelete/{orderId}",method = RequestMethod.POST)
    @ResponseBody
    public String doDelete(@PathVariable("orderId")int orderId ){
        boolean result  = userService.deleteOrder(orderId);
        if(result){
            return "success";
        }
        return "fail";
    }

    /**
     * 新增执行
     */
    @RequestMapping(value = "/doAdd",method = RequestMethod.POST )
    @ResponseBody
    public String addOrder( @RequestBody Order order){
        System.out.println(order);
        boolean result = userService.addOrder(order);
        if(result){
            return "success";
        }
        else{
            return "fail";
        }

    }
      /*
      订单列表
       */
    @RequestMapping(value = "/showOrders")
    public String getAllOrders(ModelMap modelMap){
        List<Order> orderList = userService.getOrderList();
        modelMap.addAttribute("orderList",orderList);
        return "/user/success";
    }

    /*
    用户注销
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request){
        HttpSession httpSession = request.getSession();

        if(httpSession != null){
            httpSession.removeAttribute("UserSession");
        }
        return "user/login";
    }
}
