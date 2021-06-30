package cn.com.scitc.project.servlet;

import cn.com.scitc.project.dao.LogDao;
import cn.com.scitc.project.model.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/manager/log")
public class LogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LogDao dao = new LogDao();
        List<Log> logs = dao.findAll();
        req.setAttribute("logs",logs);
        req.getRequestDispatcher("/WEB-INF/manager/log/log.jsp").forward(req,resp);
    }
}
