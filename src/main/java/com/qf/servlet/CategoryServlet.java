package com.qf.servlet;

import com.qf.pojo.Category;
import com.qf.service.CategoryService;
import com.qf.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/category/*")
public class CategoryServlet extends BaseServlet {
    private CategoryService service =new CategoryServiceImpl();

    /**
     * 查询智能设备
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public  void findSmart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str_cid = request.getParameter("cid");
        int cid = Integer.parseInt(str_cid);
        List<Category> list = service.findByCid(cid);
        writeValue(list,response);

    }

    public  void findSmartPhone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str_cid = request.getParameter("cid");
        int cid = Integer.parseInt(str_cid);
        List<Category> list = service.findByCid(cid);
        writeValue(list,response);
    }

    public  void findComputer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str_cid = request.getParameter("cid");
        int cid = Integer.parseInt(str_cid);
        List<Category> list = service.findByCid(cid);
        writeValue(list,response);
    }

    public  void findGameDevice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str_cid = request.getParameter("cid");
        int cid = Integer.parseInt(str_cid);
        List<Category> list = service.findByCid(cid);
        writeValue(list,response);
    }

}
