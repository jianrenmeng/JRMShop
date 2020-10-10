package com.qf.dao;

import com.qf.pojo.WishList;

import java.util.List;

public interface WishListDao {
    List<WishList> findAllWishGoods(int uid);
}
