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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@WebServlet(urlPatterns = "/manager/user/update")
public class UserUpdateServlet  extends HttpServlet {
    private Manager manager = new Manager();
    private ManagerDao managerDao = new ManagerDao();
    private Integer id;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Calendar calendar = Calendar.getInstance();
        Log log = new Log();
        try {
            if (!validation(req)) {
                resp.sendRedirect("edit?id=" + id);
                return;
            }

            id = Integer.parseInt(req.getParameter("id"));
            String loginId = req.getParameter("loginId");
            String realName = req.getParameter("realName");
            String pwd = req.getParameter("pwd");
            Integer loginCount = Integer.parseInt(req.getParameter("loginCount"));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date lastLoginDt = sdf.parse(req.getParameter("lastLoginDt").replace("T"," "));

            manager.setId(id);
            manager.setLoginid(loginId);
            manager.setRealname(realName);
            manager.setPwd(pwd);
            manager.setLogincount(loginCount);
            manager.setLastlogindt(lastLoginDt);
            managerDao.updateByPrimaryKey(manager);

            LogDao logDao = new LogDao();
            log.setTime(calendar.getTime());
            System.out.println(req.getAttribute("currentUser"));
            Manager currentUser = (Manager) req.getSession().getAttribute("currentUser");
            log.setLoginid(currentUser.getLoginid());
            log.setEvent("修改用户" + loginId);
            logDao.reset();
            logDao.insert(log);

            req.getSession().setAttribute("msg","修改成功");
            resp.sendRedirect("list");
        }catch (Exception e) {
            e.printStackTrace();
            req.getSession().setAttribute("msg","服务端验证失败");
            resp.sendRedirect("edit?id=" + id);
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

        return true;
    }
}
