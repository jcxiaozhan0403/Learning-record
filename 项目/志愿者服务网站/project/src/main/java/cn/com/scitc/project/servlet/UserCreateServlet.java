package cn.com.scitc.project.servlet;


import cn.com.scitc.project.dao.LogDao;
import cn.com.scitc.project.dao.ManagerDao;
import cn.com.scitc.project.model.Log;
import cn.com.scitc.project.model.Manager;
import cn.com.scitc.project.server.MyMd5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

@WebServlet(urlPatterns = "/management/user/create")
public class UserCreateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Calendar calendar = Calendar.getInstance();
        Log log = new Log();
        Manager manager = new Manager();
        try {
            if (!validation(req)) {
                resp.sendRedirect("new");
                return;
            }

            String loginId = req.getParameter("loginId");
            String realName = req.getParameter("realName");
            String pwd1 = req.getParameter("pwd1");

            manager.setLoginid(loginId);
            manager.setRealname(realName);
            manager.setPwd(MyMd5.signPwd(pwd1));

            ManagerDao managerDao = new ManagerDao();
            managerDao.reset();
            managerDao.insert(manager);

            LogDao logDao = new LogDao();
            log.setTime(calendar.getTime());
            System.out.println(req.getAttribute("currentUser"));
            Manager currentUser = (Manager) req.getSession().getAttribute("currentUser");
            log.setLoginid(currentUser.getLoginid());
            log.setEvent("添加新用户");
            logDao.reset();
            logDao.insert(log);

            req.getSession().setAttribute("msg","新增成功");
            resp.sendRedirect("list");
        }catch (Exception e) {
            req.getSession().setAttribute("msg","新增失败");
            resp.sendRedirect("new");
        }
    }

    private boolean validation(HttpServletRequest req) {
        String loginId = req.getParameter("loginId");
        if (loginId == null || loginId.length() < 6 || loginId.length() > 10) {
            System.out.println("登录名验证不通过");
            return false;
        }

        String realName = req.getParameter("realName");
        System.out.println(realName);
        if (realName == null || realName.length() < 2 || realName.length() > 5) {
            System.out.println("真实姓名验证不通过");
            return false;
        }

        String pwd1 = req.getParameter("pwd1");
        if (pwd1 == null || loginId.length() < 6 || loginId.length() > 20) {
            System.out.println("密码验证不通过");
            return false;
        }

        String pwd2 = req.getParameter("pwd2");
        if (!pwd2.equals(pwd1)) {
            System.out.println("确认密码验证不通过");
            return false;
        }

        return true;
    }
}
