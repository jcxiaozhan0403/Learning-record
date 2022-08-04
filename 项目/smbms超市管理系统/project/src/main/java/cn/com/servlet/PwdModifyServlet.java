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
 * @date 2022/8/3 16:27
 * @Description:
 */
public class PwdModifyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String oldpassword = req.getParameter("oldpassword");
        String newpassword = req.getParameter("newpassword");
        String rnewpassword = req.getParameter("rnewpassword");

        User user = (User) req.getSession().getAttribute("user");

        if (oldpassword.equals(user.getUserPassword()) && newpassword.equals(rnewpassword)) {
            UserServiceImpl userService = new UserServiceImpl();
            userService.updatePwd(user.getUserCode(),newpassword);

            req.getSession().removeAttribute("user");//移除session
            resp.sendRedirect(req.getContextPath() + "/login.jsp");//重定向到登录页面
        }else {
            req.setAttribute("message","修改失败，请正确填写表单信息!");
            req.getRequestDispatcher("/jsp/pwdmodify.jsp").forward(req,resp);
        }
    }
}
