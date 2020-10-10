package com.qf.service.impl;

import com.qf.dao.WishListDao;
import com.qf.dao.impl.WishListDaoImpl;
import com.qf.pojo.WishList;
import com.qf.service.WishListService;

import java.util.List;

public class WishListServiceImpl implements WishListService {
    private WishListDao dao= new  WishListDaoImpl();
    @Override
    public List<WishList> findAllWishGoods(int uid) {
       List<WishList> list= dao.findAllWishGoods(uid);
        return list;
    }
}
