package com.qf.servlet;


import com.qf.pojo.User;
import com.qf.pojo.Wish;
import com.qf.pojo.WishList;
import com.qf.service.GoodsService;
import com.qf.service.WishListService;
import com.qf.service.impl.GoodsServiceImpl;
import com.qf.service.impl.WishListServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/wishListServlet/*")
public class WishListServlet extends BaseServlet {
    private WishListService service = new WishListServiceImpl();
    private GoodsService gsevice=new GoodsServiceImpl();

    /**
     * 查看用户所有的愿望单
     *
     * @throws ServletException
     * @throws IOException
     */
    public void findAllWishGoods(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) requset.getSession().getAttribute("user");
        if (user == null) {
            return;
        } else {
            int uid = user.getUid();
            List<WishList> list = service.findAllWishGoods(uid);
            writeValue(list, response);
        }
    }

    public void removeWishList(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException {
        String str_gid = requset.getParameter("gid");
        int gid = Integer.parseInt(str_gid);
        User user = (User) requset.getSession().getAttribute("user");
        if (user == null) {
            return;
        } else {
            int uid = user.getUid();
            gsevice.removeWish(gid,uid);
        }

    }
}
