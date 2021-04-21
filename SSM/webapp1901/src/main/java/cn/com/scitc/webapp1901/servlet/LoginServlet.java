package cn.com.scitc.webapp1901.servlet;

import cn.com.scitc.webapp1901.dao.ManagerDao;
import cn.com.scitc.webapp1901.model.Manager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = {"/login"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loginId = request.getParameter("loginId");
        String password = request.getParameter("password");
        ManagerDao managerDao = new ManagerDao();
        Manager manager = managerDao.findById(loginId);
        if (password.equals(manager.getPwd())){
            request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("/WEB-INF/login.jsp?error=yes").forward(request,response);
        }
    }
}
