package cn.com.scitc.webapp1901.servlet;

import cn.com.scitc.webapp1901.dao.ManagerDao;
import cn.com.scitc.webapp1901.model.Manager;
import cn.com.scitc.webapp1901.server.MyMd5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Calendar;

@WebServlet(urlPatterns = "/manager/checkLogin")
public class CheckLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loginId = req.getParameter("loginId");
        String password = req.getParameter("password");

        final boolean result = MyMd5.validateManager(loginId, password);

        if (result) {
            HttpSession session = req.getSession();
            ManagerDao dao = new ManagerDao();
            Manager manager = dao.findByLoginId(loginId);

            // 更新登陆次数
            if (manager.getLogincount() == null){
                manager.setLogincount(1);
            }else {
                manager.setLogincount(manager.getLogincount() + 1);
            }

            // 更新最后一次登陆时间
            Calendar calendar = Calendar.getInstance();
            manager.setLastlogindt(calendar.getTime());

            dao.updateByPrimaryKey(manager);

            // 保存session
            session.setAttribute("currentUser",manager);

            // 跳转到主页
            resp.sendRedirect("home");
        }else {
            req.getSession().setAttribute("loginMsg","用户名或者密码错误");
            resp.sendRedirect("login");
        }
    }
}
