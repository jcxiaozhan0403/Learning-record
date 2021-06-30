package cn.com.scitc.project.servlet;


import cn.com.scitc.project.dao.LogDao;
import cn.com.scitc.project.dao.ManagerDao;
import cn.com.scitc.project.model.Log;
import cn.com.scitc.project.model.Manager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

@WebServlet(urlPatterns = "/manager/user/delete")
public class UserDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Calendar calendar = Calendar.getInstance();
        Log log = new Log();
        try{
            String id = req.getParameter("id");
            ManagerDao managerDao = new ManagerDao();
            String loginid = managerDao.findById(Integer.parseInt(id)).getLoginid();
            managerDao.deleteByPrimaryKey(Integer.parseInt(id));

            LogDao logDao = new LogDao();
            log.setTime(calendar.getTime());
            Manager currentUser = (Manager) req.getSession().getAttribute("currentUser");
            log.setLoginid(currentUser.getLoginid());
            log.setEvent("删除用户" + loginid);
            logDao.reset();
            logDao.insert(log);

            req.getSession().setAttribute("msg","删除成功");
            resp.sendRedirect("list");
        }catch (Exception e) {
            req.getSession().setAttribute("msg","删除失败");
            resp.sendRedirect("list");
        }

    }
}
