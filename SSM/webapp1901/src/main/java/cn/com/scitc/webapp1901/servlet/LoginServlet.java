package cn.com.scitc.webapp1901.servlet;

import cn.com.scitc.webapp1901.dao.StudentDao;
import cn.com.scitc.webapp1901.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = {"/login"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentId = request.getParameter("studentId");
        String pwd = request.getParameter("pwd");
        StudentDao studentDao = new StudentDao();
        Student student = studentDao.findByStudentId(studentId);
        if (pwd.equals(student.getPwd())){
            System.out.println("验证通过");
        }else {
            System.out.println("验证失败");
        }
    }
}
