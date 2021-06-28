package cn.com.scitc.project.servlet;

import cn.com.scitc.project.dao.ImageDao;
import cn.com.scitc.project.model.Image;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = {"/manager/login"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ImageDao dao = new ImageDao();
        Image image = dao.findImageById(4);
        request.setAttribute("loginbk",image.getUrl());
        request.getRequestDispatcher("/WEB-INF/manager/login.jsp").forward(request,response);
    }
}