package com.qf.service;

import com.qf.pojo.Order;

import java.util.List;

public interface OrderService {
    void addOrder(int id, int aid);
    List<Order> findOrderByUid(int uid) ;
}
