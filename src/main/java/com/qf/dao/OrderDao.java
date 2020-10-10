package com.qf.dao;

import com.qf.pojo.Order;

import java.util.List;

public interface OrderDao {
    void addOrder(Order order, int uid, int gid);
    List<Order>  findOrderByuid(int uid);
}
