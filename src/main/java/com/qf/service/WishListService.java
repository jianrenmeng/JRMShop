package com.qf.service;

import com.qf.pojo.WishList;

import java.util.List;

public interface WishListService {
    List<WishList> findAllWishGoods(int uid);
}
