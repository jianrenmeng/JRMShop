package com.qf.servlet;

import com.qf.pojo.ShopCar;
import com.qf.pojo.User;
import com.qf.pojo.WishList;
import com.qf.service.CarService;
import com.qf.service.impl.CarServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/carServlet/*")
public class CarServlet  extends BaseServlet{
    private CarService service = new CarServiceImpl();
    /**
     * 查看用户所有购物车
     * @throws ServletException
     * @throws IOException
     */
    public void findAllCarGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return;
        } else {
            int uid = user.getUid();
            List<ShopCar> list = service.findAllCarGoods(uid);
            writeValue(list, response);
        }
    }


    /**
     * 修改商品数量
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void updateCarNumber(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sid = request.getParameter("id");
        String snumber = request.getParameter("number");
        String sprice = request.getParameter("price");
        if(sid==null && snumber==null && sprice ==null){
            return;
        }
        int id = Integer.parseInt(sid);
        int number = Integer.parseInt(snumber);
        int price = Integer.parseInt(sprice);
        service.updateCarNumber(id,number,price);

    }

    /**
     * 删除 商品
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void deleteCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        service.deleteCar(id);
    }

    /**
     * 清楚所有
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void clearAllCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return;
        } else {
            int uid = user.getUid();
            service.clearAllCar(uid);
        }
    }

    /**
     * 添加购物车
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void addCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str_gid = request.getParameter("gid");
        int gid = Integer.parseInt(str_gid);
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return;
        } else {
            int uid = user.getUid();
           service.addCar(gid,uid);
        }
    }

    public void findOneCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str_id = request.getParameter("id");
        int id = Integer.parseInt(str_id);
        ShopCar car=service.findOneCar(id);
        writeValue(car,response);

    }

}
