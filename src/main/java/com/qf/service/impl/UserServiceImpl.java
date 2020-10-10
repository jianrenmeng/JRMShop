package com.qf.service.impl;

import com.qf.dao.UserDao;
import com.qf.dao.impl.UserDaoImpl;
import com.qf.pojo.User;
import com.qf.service.UserService;

import java.util.List;

public class UserServiceImpl  implements UserService {
    private UserDao dao=new UserDaoImpl();
    /**
     * 用户注册功能
     * @param user
     * @return
     */
    @Override
    public boolean register(User user) {

        int count=dao.register(user);
        if (count==0){
            return false;
        }else {
            return true;
        }
    }

    /**
     * 验证注册时用户名是否存在
     * @param username
     * @return
     */
    @Override
    public boolean findRegUsername(String username) {
        List<User> list = dao.findRegUsername(username);
        if (list.isEmpty()){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 激活功能
     * @param code
     * @return
     */
    @Override
    public boolean active(String code) {
        //先查询code是否 存再用户
        User user=dao.findUserByCode(code);
        if (user!=null){
            //激活用户
            int count=dao.active(user);
            if (count==0){
                return false;
            }else {
                return true;
            }
        }else {
            return  false;
        }
    }

    @Override
    public boolean findRegEmail(String email) {
        List<User> list = dao.findRegEmail(email);
        if (list.isEmpty()){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 登录功能
     * @param loginname
     * @param loginpassword
     * @return
     */
    @Override
    public User login(String loginname, String loginpassword) {
       User user= dao.login(loginname,loginpassword);
      return user;
    }


}
