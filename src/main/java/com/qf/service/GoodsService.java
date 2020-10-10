package com.qf.service;

import com.qf.pojo.Goods;
import com.qf.pojo.Page;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

public interface GoodsService {
    /**
     * 查询所有商品
     * @throws ServletException
     * @throws IOException
     */
    Page<Goods> findAllPage(Page page,String gname);

    /**
     * 根据cid查询
     * @param page
     * @param cid
     * @return
     */
    Page<Goods> findGoodsByCid(Page page,int cid);

    /**
     * 根据商品的id查询
     * @param gid
     * @return
     */
    Goods findGoodsByGid(String gid);

    /**
     * 添加愿望单
     * @param gid
     * @param uid
     * @return
     */
    boolean addWishGoods(int gid, int uid);

    /**
     * 查看是否存在
     * @param gid
     * @param uid
     * @return
     */
    boolean isWishGoods(int gid, int uid);

    /**
     * 移除愿望单
     * @param gid
     * @param uid
     */
    void removeWish(int gid, int uid);

    /**
     * 查询推荐商品
     * @return
     */
    List<Goods> findRecommend();
}
