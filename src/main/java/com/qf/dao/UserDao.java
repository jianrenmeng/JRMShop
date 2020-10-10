package com.qf.dao;

import com.qf.pojo.User;

import java.util.List;

public interface UserDao {
    /**
     * 注册用户
     * @param user
     * @return
     */
    public  int  register(User user);

    /**
     * 测试注册时  是否用户是否存在
     * @param username
     * @return
     */
    public List<User> findRegUsername(String username);

    /**
     * 根据code  来查询用户
     * @param code
     * @return
     */
    User findUserByCode(String code);
    /**
     * 激活用户
     * @param user
     * @return
     */
    int active(User user);

    /**
     * 验证邮箱是否存在
     * @param email
     * @return
     */
    List<User> findRegEmail(String email);

    /**
     * 登录方法
     * @param loginname
     * @param loginpassword
     * @return
     */
    User login(String loginname, String loginpassword);
}
