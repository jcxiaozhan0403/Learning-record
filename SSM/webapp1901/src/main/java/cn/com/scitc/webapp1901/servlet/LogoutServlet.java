package cn.com.scitc.webapp1901.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/manager/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 清除Session
        req.getSession().removeAttribute("currentUser");
        req.getSession().removeAttribute("msg");
        // 跳转到登录页
        resp.sendRedirect("login");
    }
}
