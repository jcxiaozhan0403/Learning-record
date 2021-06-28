package cn.com.scitc.project.servlet;

import cn.com.scitc.project.dao.ImageDao;
import cn.com.scitc.project.model.Image;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/page1")
public class Page1_Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ImageDao dao = new ImageDao();
        Image image = dao.findImageById(1);
        req.setAttribute("page1bk",image.getUrl());
        req.getRequestDispatcher("/WEB-INF/page1.jsp").forward(req,resp);
    }
}