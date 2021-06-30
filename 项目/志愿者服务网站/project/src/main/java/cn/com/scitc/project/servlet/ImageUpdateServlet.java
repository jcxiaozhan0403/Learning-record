package cn.com.scitc.project.servlet;

import cn.com.scitc.project.dao.ImageDao;
import cn.com.scitc.project.dao.LogDao;
import cn.com.scitc.project.model.Image;
import cn.com.scitc.project.model.Log;
import cn.com.scitc.project.model.Manager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

@WebServlet(urlPatterns = "/manager/image/update")
public class ImageUpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Calendar calendar = Calendar.getInstance();
        Log log = new Log();
        try{
            String name = req.getParameter("name");
            String url = req.getParameter("url");
            ImageDao dao = new ImageDao();
            Image image = dao.findImageByName(name);
            image.setUrl(url);
            dao.updateByPrimaryKey(image);

            LogDao logDao = new LogDao();
            log.setTime(calendar.getTime());
            System.out.println(req.getAttribute("currentUser"));
            Manager currentUser = (Manager) req.getSession().getAttribute("currentUser");
            log.setLoginid(currentUser.getLoginid());
            switch (name) {
                case "page1" : log.setEvent("修改文明川信背景图"); break;
                case "page2" : log.setEvent("修改川信志愿者背景图"); break;
                case "page3" : log.setEvent("修改雷锋热线背景图"); break;
                case "login" : log.setEvent("修改登录页背景图"); break;
            }
            logDao.reset();
            logDao.insert(log);

            req.getSession().setAttribute("msg","修改成功！");
        }catch (Exception e) {
            req.getSession().setAttribute("msg","修改失败！");
            e.printStackTrace();
        }
        resp.sendRedirect("list");
    }
}