package com.qf.servlet;

import com.qf.pojo.Order;
import com.qf.pojo.User;
import com.qf.service.OrderService;
import com.qf.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/orderServlet/*")
public class OrderServlet extends BaseServlet {
    private OrderService service = new OrderServiceImpl();

    /**
     * 增加订单
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void addOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str_id = request.getParameter("id");
        String str_aid = request.getParameter("aid");
        int id = Integer.parseInt(str_id);
        int aid = Integer.parseInt(str_aid);
        service.addOrder(id, aid);
    }

    /**
     * 展示所有订单
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void showOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        int uid = user.getUid();
        List<Order> list = service.findOrderByUid(uid);
        writeValue(list, response);
    }

}
