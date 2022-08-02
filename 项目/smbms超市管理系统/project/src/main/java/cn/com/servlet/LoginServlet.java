package cn.com.servlet;

import cn.com.pojo.User;
import cn.com.service.user.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author John.Cena
 * @date 2022/8/2 17:48
 * @Description:
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取前端参数
        String userCode = req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");

        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.getUser(userCode);
        if(user == null){
            req.setAttribute("error","没有该用户");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }else {
            if (user.getUserPassword().equals(userPassword)) {
                req.getSession().setAttribute("user",user);
                resp.sendRedirect("jsp/frame.jsp");
            }else {
                req.setAttribute("error","用户名密码错误");
                req.getRequestDispatcher("login.jsp").forward(req,resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
