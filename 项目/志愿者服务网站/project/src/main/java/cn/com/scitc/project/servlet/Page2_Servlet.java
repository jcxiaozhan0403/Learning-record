package cn.com.scitc.project.servlet;

import cn.com.scitc.project.dao.ImageDao;
import cn.com.scitc.project.model.Image;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/page2")
public class Page2_Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ImageDao dao = new ImageDao();
        Image image = dao.findImageById(2);
        req.setAttribute("page2bk",image.getUrl());
        req.getRequestDispatcher("/WEB-INF/page2.jsp").forward(req,resp);
    }
}