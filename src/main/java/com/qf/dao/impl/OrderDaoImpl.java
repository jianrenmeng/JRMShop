package com.qf.dao.impl;

import com.qf.dao.OrderDao;
import com.qf.pojo.Order;
import com.qf.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class OrderDaoImpl implements OrderDao {
    private JdbcTemplate jd = new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public void addOrder(Order order, int uid, int gid) {
        int count = 0;
        try {
            String sql="insert into orders values(?,?,?,?,?,?,?)";
            count = jd.update(sql, order.getOid(), order.getAddress(), order.getTime(), order.getStatu(), order.getTotalmoney(), uid, gid);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        System.out.println(count);

    }

    public List<Order>  findOrderByuid(int uid){

        try {
            String sql="select * from  orders where uid=?";
            List<Order> list =  jd.query(sql, new BeanPropertyRowMapper<Order>(Order.class), uid);
            System.out.println(list);
            return list;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }


    }
}
