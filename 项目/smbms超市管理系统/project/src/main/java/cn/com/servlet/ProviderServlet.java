package cn.com.servlet; /**
 * @author John.Cena
 * @date 2022/8/5 8:50
 * @Description: ${todo}
 */

import cn.com.pojo.Pro;
import cn.com.service.user.BillService;
import cn.com.service.user.impl.BillServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class ProviderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BillService billService = new BillServiceImpl();
        List<Pro> providerList = billService.getProList();

        request.getSession().setAttribute("providerList",providerList);

        request.getRequestDispatcher("/jsp/providerlist.jsp").forward(request,response);
    }
}
