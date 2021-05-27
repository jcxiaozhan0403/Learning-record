package cn.com.scitc.webapp1901.servlet;

import cn.com.scitc.webapp1901.dao.ManagerDao;
import cn.com.scitc.webapp1901.model.Manager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/manager/user/edit")
public class UserEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String id = req.getParameter("id");
            ManagerDao managerDao = new ManagerDao();
            Manager manager = managerDao.selectByPrimaryKey(Integer.parseInt(id));
            req.setAttribute("model",manager);
            req.getRequestDispatcher("/WEB-INF/manager/user/edit.jsp").forward(req,resp);
        }catch (Exception e) {
            resp.sendRedirect("list");
        }
    }
}
