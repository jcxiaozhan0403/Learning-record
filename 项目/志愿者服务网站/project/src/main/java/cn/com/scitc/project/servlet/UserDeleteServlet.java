package cn.com.scitc.project.servlet;


import cn.com.scitc.project.dao.ManagerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/manager/user/delete")
public class UserDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String id = req.getParameter("id");
            ManagerDao managerDao = new ManagerDao();
            managerDao.deleteByPrimaryKey(Integer.parseInt(id));
            req.getSession().setAttribute("msg","删除成功");
            resp.sendRedirect("list");
        }catch (Exception e) {
            req.getSession().setAttribute("msg","删除失败");
            resp.sendRedirect("list");
        }

    }
}
