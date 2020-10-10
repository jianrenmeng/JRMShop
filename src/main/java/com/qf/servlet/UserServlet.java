package com.qf.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qf.pojo.ResultInfo;
import com.qf.pojo.User;
import com.qf.service.UserService;
import com.qf.service.impl.UserServiceImpl;
import com.qf.utils.MailUtils;
import com.qf.utils.UuidUtil;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Set;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    private  UserService service = new UserServiceImpl();


    /**
     * 注册功能
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public  void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据
        Map<String, String[]> map =request.getParameterMap();
        String realname = request.getParameter("realname");
        String password = request.getParameter("password");
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        user.setRealname(realname);
        user.setPassword(password);
        user.setFlag(0);
        user.setCode(UuidUtil.getUuid());
        boolean flag = service.register(user);
        ResultInfo info=new ResultInfo();
        if (flag){
            info.setFlag(true);

            //3.激活邮件发送，邮件正文？
            String content="<div style=\"width: 500px;height: 600px;background-color:#0FA8CE;font-size: 30px;margin: auto\">\n" +
                    "    <p style=\"text-align: center ;padding-top: 200px;font-family: 楷体\">\n" +
                    "        【JRMShop】账号激活：点击<a href=\"http://localhost:8080/JRMShop/user/active?code="+user.getCode()+"\" style=\"color: #CE5B0F\">此处</a>进行账号激活\n" +
                    "    </p>\n" +
                    "</div>";
            MailUtils.sendMail(user.getEmail(),content,"JRMShop激活邮件");
        }else {
            info.setFlag(false);
        }
        //把结果对象转为json 设置content-type
        response.setContentType("application/json;charset=utf-8");
        //转json
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(info);
        //写会客户端
        response.getWriter().write(json);



    }

    /**
     * 测试用户名是否存在
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findRegUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        boolean flag=service.findRegUsername(username);
        ResultInfo info=new ResultInfo();
        if (flag){
            info.setFlag(true);
        }else{
            info.setFlag(false);
        }
        //转为json
        //把结果对象转为json 设置content-type
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(info);
        response.getWriter().write(json);
    }

    /**
     * 测试邮箱是否存在
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findRegEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        boolean flag=service.findRegEmail(email);
        ResultInfo info=new ResultInfo();
        if (flag){
            info.setFlag(true);
        }else{
            info.setFlag(false);
        }
        //转为json
        //把结果对象转为json 设置content-type
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(info);
        response.getWriter().write(json);
    }

    /**
     * 激活账号
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void active(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        if (code!=null){
            boolean flag=service.active(code);
            if (flag){
                response.sendRedirect(request.getContextPath()+"/ok.html");
            }else {
                response.sendRedirect(request.getContextPath()+"/false.html");
            }
        }else{
            response.sendRedirect(request.getContextPath()+"/false.html");
        }


    }

    /**
     * 用户登录功能
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loginname = request.getParameter("loginname");
        String loginpassword = request.getParameter("loginpassword");
        User user=service.login(loginname,loginpassword);
        ResultInfo info = new ResultInfo();
        if (user==null){
            info.setFlag(false);
            info.setErrorMsg("用户名或密码错误");
        }
        if (user!=null &&  user.getFlag()==0){
            info.setFlag(false);
            info.setErrorMsg("账户未激活,请前往邮箱激活");
        }
        if (user!=null &&  user.getFlag()==1){
            request.getSession().setAttribute("user",user);
            info.setFlag(true);
        }
        ObjectMapper mapper = new ObjectMapper();
        //设置响应头
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),info);
    }

    /**
     * 查看session中有没有数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object user = request.getSession().getAttribute("user");
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        ResultInfo info = new ResultInfo();
        if (user==null){
            info.setFlag(false);
        }else {
            info.setFlag(true);
            info.setData(user);
        }
        mapper.writeValue(response.getOutputStream(),info);
    }

    /**
     * 退出
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath()+"/index.html");
    }

}
