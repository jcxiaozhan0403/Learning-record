package cn.com.scitc.webapp1901.servlet;

import cn.com.scitc.webapp1901.dao.ManagerDao;
import cn.com.scitc.webapp1901.model.Manager;
import cn.com.scitc.webapp1901.server.MyMd5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/manager/checkLogin")
public class CheckLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loginId = req.getParameter("loginId");
        String password = req.getParameter("password");

        final boolean result = MyMd5.validateManager(loginId, password);

        if (result) {
            resp.sendRedirect("home");
        }else {
            resp.sendRedirect("login?error=yes");
        }
    }
}
