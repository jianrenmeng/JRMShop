package com.qf.dao;

import com.qf.pojo.Goods;
import com.qf.pojo.Page;

import java.util.List;

public interface GoodsDao {
    long findAllCount(String name);
    long findByCid(int cid);
    List<Goods> findAllPage(Page page,String name);

    List<Goods> findGoodsByCid(Page page, int cid);

    Goods findGoodsByGid(int gid);

    boolean addWishGood(int gid, int uid);

    boolean isWishGoods(int gid, int uid);

    /**
     * 移除愿望单
     * @param gid
     * @param uid
     * @return
     */
    void removeWishGoods(int gid,int uid);

    List<Goods> findRocommend();
}
