package com.qf.servlet;

import com.qf.pojo.Address;
import com.qf.pojo.ResultInfo;
import com.qf.pojo.User;
import com.qf.service.AddressService;
import com.qf.service.impl.AddressServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/addressServlet/*")
public class AddressServlet extends BaseServlet {
    private  AddressService service= new AddressServiceImpl();
    public void addAddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        Address address = new Address();
        try {
            BeanUtils.populate(address,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        int size = map.size();
        ResultInfo info=new ResultInfo();
        if (address.getAname().length()<1 || address.getAemail().length()<1 || address.getCity().length()<1 &&address.getDetailaddress().length()<1||address.getTelphone().length()<1){
            info.setFlag(false);
            writeValue(info,response);
            return;
        }


        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return;
        } else {
            int uid = user.getUid();
           address.setUid(uid);
           System.out.println(address+"在servlet中");
            //调用servi方法
            boolean flag=service.addAddress(address);
            if (flag){
                info.setFlag(true);
            }else{
                info.setFlag(false);
            }
            writeValue(info,response);
        }
    }
    public void findAllAddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return;
        } else {
            int uid = user.getUid();
            List<Address> list =service.findAllAddress(uid);
            writeValue(list,response);
        }
    }

    /**
     * 查询一个
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findOneAddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String str_aid = request.getParameter("aid");
        int aid = Integer.parseInt(str_aid);
        Address address=service.findOneAddress(aid);
        writeValue(address,response);
    }

    /**
     * 删除 地址
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void removeAddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String str_aid = request.getParameter("aid");
        int aid = Integer.parseInt(str_aid);
        service.removeAddress(aid);
    }
}
