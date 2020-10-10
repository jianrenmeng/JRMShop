package com.qf.service.impl;

import com.qf.dao.GoodsDao;
import com.qf.dao.impl.GoodsDaoImpl;
import com.qf.pojo.Goods;
import com.qf.pojo.Page;
import com.qf.service.GoodsService;
import sun.security.util.Length;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    private GoodsDao dao=new GoodsDaoImpl();
    /**
     * 查找所有商品
     * @param page
     * @return
     */
    @Override
    public Page<Goods> findAllPage(Page page,String gname) {
        //获取总条数
        int totalCount =(int) dao.findAllCount(gname);
        //把数量设置给page
        page.setTotalCounts(totalCount);
        //获取学生数据
        List<Goods> list = dao.findAllPage(page,gname);
        if (list==null || list.size()==0){
            return null;
        }
        page.setList(list);
        return page;

    }

    @Override
    public Page<Goods> findGoodsByCid(Page page, int cid) {
        //获取总条数
        int totalCount =(int) dao.findByCid(cid);
        //把数量设置给page
        page.setTotalCounts(totalCount);
        //获取学生数据
        List<Goods> list = dao.findGoodsByCid(page,cid);
        if (list==null || list.size()==0){
            return null;
        }
        page.setList(list);
        return page;
    }

    @Override
    public Goods findGoodsByGid(String str_gid) {
        int gid =0;
        if(str_gid != null && str_gid.length()> 0){
            gid = Integer.parseInt(str_gid);
        }
      Goods goods=  dao.findGoodsByGid(gid);
        return goods;
    }

    @Override
    public boolean addWishGoods(int gid, int uid) {
        boolean flag=dao.addWishGood(gid,uid);
        return flag;
    }

    @Override
    public boolean isWishGoods(int gid, int uid) {
        boolean flag=dao.isWishGoods(gid,uid);
        return flag;
    }

    /**
     * 移除愿望单
     * @param gid
     * @param uid
     */
    @Override
    public void removeWish(int gid, int uid) {
        dao.removeWishGoods(gid, uid);
    }

    @Override
    public List<Goods> findRecommend() {
        List<Goods> goods=dao.findRocommend();
        return goods;
    }


}
