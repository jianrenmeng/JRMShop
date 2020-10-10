package com.qf.servlet;

import com.qf.pojo.Goods;
import com.qf.pojo.Page;
import com.qf.pojo.ResultInfo;
import com.qf.pojo.User;
import com.qf.service.GoodsService;
import com.qf.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.server.UID;
import java.util.List;

@WebServlet("/goodsServlet/*")
public class GoodsServlet extends BaseServlet {

    private GoodsService service = new GoodsServiceImpl();

    /**
     * 查询所有商品
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findGoodsAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //当前页码
        String currentPageStr = request.getParameter("currentPage");
        String gname = request.getParameter("gname");
        gname = new String(gname.getBytes("iso-8859-1"), "utf-8");

        //判断是否存在
        int currentPage = 0;//当前页码，如果不传递，则默认为第一页
        if (currentPageStr != null && currentPageStr.length() > 0) {
            currentPage = Integer.parseInt(currentPageStr);
        } else {
            currentPage = 1;
        }
        if (gname != null && gname.length() > 0) {
            gname = gname;
        } else {
            gname = null;
        }
        //创建对象`
        Page page = new Page(currentPage);
        Page<Goods> pg = service.findAllPage(page, gname);
        writeValue(pg, response);


    }

    /**
     * 根据cid查询 商品
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findGoodsByCid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //当前页码
        //当前页码
        String currentPageStr = request.getParameter("currentPage");
        String str_cid = request.getParameter("cid");
        //判断是否存在
        int currentPage = 0;//当前页码，如果不传递，则默认为第一页
        if (currentPageStr != null && currentPageStr.length() > 0) {
            currentPage = Integer.parseInt(currentPageStr);
        } else {
            currentPage = 1;
        }
        int cid = 0;//类别id
        //2.处理参数
        if (str_cid != null && str_cid.length() > 0 && !"null".equals(str_cid)) {
            cid = Integer.parseInt(str_cid);
        }

        //创建对象`
        Page page = new Page(currentPage);
        Page<Goods> pg = service.findGoodsByCid(page, cid);
        writeValue(pg, response);
    }

    /**
     * 详细产品信息
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findGoodByGid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String gid = request.getParameter("gid");
        Goods goods = service.findGoodsByGid(gid);
        writeValue(goods, response);
    }

    /**
     * 增加愿望单
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void addWishGood(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取gid
        String str_gid = request.getParameter("gid");
        //查看是否登录
        User user = (User) request.getSession().getAttribute("user");
        int uid;
        if (user == null) {
            return;
        } else {
            ResultInfo result = new ResultInfo();
            int gid = Integer.parseInt(str_gid);
            uid = user.getUid();
            boolean wishFlag = service.isWishGoods(gid, uid);
            System.out.println("wishFlag+"+wishFlag);
            if (wishFlag) {
                service.removeWish(gid, uid);
                //先看是否已经添加了
                result.setFlag(false);
                writeValue(result, response);
                return;
            } else {
                boolean flag = service.addWishGoods(gid, uid);
                result.setFlag(flag);
                writeValue(result, response);
            }

        }

    }

    /**
     * 查看是否收藏过商品
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void isWish(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取gid
        String str_gid = request.getParameter("gid");
        //查看是否登录
        User user = (User) request.getSession().getAttribute("user");
        int uid;
        if (user == null) {
            return;
        } else {
            ResultInfo result = new ResultInfo();
            int gid = Integer.parseInt(str_gid);
            uid = user.getUid();
            boolean wishFlag = service.isWishGoods(gid, uid);
            if (wishFlag){
                result.setFlag(true);
                writeValue(result, response);
                return;
            }else {
                result.setFlag(false);
                writeValue(result, response);
            }

        }
    }

    /**
     * 查询推荐的商品
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findRecommend(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Goods> list = service.findRecommend();
        writeValue(list,response);
    }

}
