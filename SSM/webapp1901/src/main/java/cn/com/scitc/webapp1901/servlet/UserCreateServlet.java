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

@WebServlet(urlPatterns = "/manager/user/create")
public class UserCreateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
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

            System.out.println("新增成功");
            req.getSession().setAttribute("msg","新增成功");
            resp.sendRedirect("list");
        }catch (Exception e) {
            System.out.println("新增失败");
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
