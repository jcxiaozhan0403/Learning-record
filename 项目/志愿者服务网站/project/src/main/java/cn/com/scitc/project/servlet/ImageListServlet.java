package cn.com.scitc.project.servlet;

import cn.com.scitc.project.dao.ImageDao;
import cn.com.scitc.project.model.Image;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet(urlPatterns = "/management/image/list")
public class ImageListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ImageDao dao = new ImageDao();
        List<Image> images = dao.findAll();
        HashMap<String,String> map = new HashMap<>();
        for (Image image : images) {
            map.put(image.getName(),image.getUrl());
        }
        req.setAttribute("images",map);
        req.getRequestDispatcher("/WEB-INF/management/image/list.jsp").forward(req,resp);
    }
}