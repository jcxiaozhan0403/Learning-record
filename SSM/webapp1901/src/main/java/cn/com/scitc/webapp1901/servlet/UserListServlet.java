package cn.com.scitc.webapp1901.servlet;

import cn.com.scitc.webapp1901.dao.ManagerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/manager/userlist")
public class UserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ManagerDao managerDao = new ManagerDao();
        List managers = managerDao.selectAll();
        req.setAttribute("managers",managers);
        req.getRequestDispatcher("/WEB-INF/manager/user/list.jsp").forward(req,resp);
    }
}