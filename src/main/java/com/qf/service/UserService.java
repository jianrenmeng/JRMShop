package com.qf.service;

import com.qf.pojo.User;

public interface UserService {
    public boolean register(User user);

    /**
     *  测试注册时 用户名是否存在
     */

    public boolean findRegUsername(String username);

    /**
     * 激活用户
     * @param code
     * @return
     */
    boolean active(String code);

    boolean findRegEmail(String email);

    User login(String loginname, String loginpassword);
}
