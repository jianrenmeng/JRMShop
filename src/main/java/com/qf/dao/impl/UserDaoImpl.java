package com.qf.dao.impl;

import com.qf.dao.UserDao;
import com.qf.pojo.User;
import com.qf.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate jd=new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 用户注册功能
     * @param user
     * @return
     */
    @Override
    public int register(User user) {
        String sql="insert into user values (null,?,?,?,?,?,?,?,?)";
        int count = jd.update(sql, user.getUsername(), user.getRealname(), user.getGender(), user.getTelphone(), user.getEmail(),user.getPassword(),user.getFlag(),user.getCode());
        return count;
    }

    /**
     * 注册时 查询用户是否存在
     * @param username
     * @return
     */
    @Override
    public List<User> findRegUsername(String username) {

        List<User> list=null;
        try {
            String sql="select * from user where username=?";
            list = jd.query(sql, new BeanPropertyRowMapper<User>(User.class), username);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }


    /**
     * 根据code 来查询用户
     * @param code
     * @return
     */
    @Override
    public User findUserByCode(String code) {
        User  user=null;
        try {
            String sql="select * from user where code = ?";
            user = jd.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), code);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  user;
    }
    /**
     * 激活用户
     * @param user
     * @return
     */
    @Override
    public int active(User user) {
        String sql="update user set flag= 1 where uid =?";
        int count = jd.update(sql, user.getUid());
        return count;
    }

    /**
     * 验证邮箱是否存在
     * @param email
     * @return
     */
    @Override
    public List<User> findRegEmail(String email) {
        List<User> list=null;
        try {
            String sql="select * from user where email=?";
            list = jd.query(sql, new BeanPropertyRowMapper<User>(User.class), email);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 登录功能
     * @param loginname
     * @param loginpassword
     * @return
     */
    @Override
    public User login(String loginname, String loginpassword) {
        User user =null;
        List<User> list =null;
        try {
            String sql="select * from user where username=? and password=?";
             list = jd.query(sql, new BeanPropertyRowMapper<User>(User.class), loginname, loginpassword);
            if (list.size()==0 &&  list==null){
                return  null;
            }
            user = list.get(0);
        }catch (Exception e ){
            e.printStackTrace();
        }
        return  user;

    }


}
