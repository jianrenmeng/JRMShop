package com.qf.dao.impl;

import com.qf.dao.GoodsDao;
import com.qf.pojo.Goods;
import com.qf.pojo.Page;
import com.qf.pojo.Wish;
import com.qf.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class GoodsDaoImpl implements GoodsDao {
    private JdbcTemplate jd = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public long findAllCount(String gname) {
        String sql = "select count(*) from goods  ";
        StringBuilder sb = new StringBuilder(sql);
        List params = new ArrayList<>();
        if (gname != null && gname.length() > 0 && !"null".equals(gname)) {
            sb.append(" where gname like  ? ");
            sql = sb.toString();
            return jd.queryForObject(sql, Long.class, "%" + gname + "%");
        } else {
            sql = sb.toString();
            return jd.queryForObject(sql, Long.class);
        }
    }

    /**
     * 查看所有产品
     * @param page
     * @param gname
     * @return
     */
    @Override
    public List<Goods> findAllPage(Page page, String gname) {

        String sql = "SELECT t1.*,t2.* FROM goods t1 LEFT JOIN picture t2 on t1.pic = t2.pid ";
        StringBuilder sb = new StringBuilder(sql);
        List params = new ArrayList<>();
        if (gname != null &&  !gname.equals("null")) {
            sb.append(" where gname like  ?  limit ?,?");
            sb.toString();
            params.add("%"+gname+"%");
        } else {
            sb.append(" limit ?,?");
            sb.toString();
        }
        params.add(page.getStartRows());
        params.add(page.getPageSize());
        sql = sb.toString();
        try {
            List<Goods> list = jd.query(sql, new BeanPropertyRowMapper<Goods>(Goods.class), params.toArray());
            return list;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 根据cid查询条数
     *
     * @param cid
     * @return
     */
    @Override
    public long findByCid(int cid) {
        String sql = "select count(*) from goods where cid=?";
        long count = jd.queryForObject(sql, Long.class, cid);
        return count;
    }

    /**
     * cid 查询
     *
     * @param page
     * @param cid
     * @return
     */
    @Override
    public List<Goods> findGoodsByCid(Page page, int cid) {
        try {
            String sql = "select t1.*,t2.* FROM( SELECT * FROM goods where cid= ? ) t1 JOIN picture t2 where t1.pic= t2.pid limit ?,?";
            List<Goods> list = jd.query(sql, new BeanPropertyRowMapper<Goods>(Goods.class), cid, page.getStartRows(), page.getPageSize());
            return list;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 详细产品信息
     * @param gid
     * @return
     */
    @Override
    public Goods findGoodsByGid(int gid) {
        try {
            String sql = "SELECT t1.*,t2.* FROM goods t1 LEFT JOIN picture t2 on t1.pic = t2.pid  where gid=?";
            Goods goods = jd.queryForObject(sql, new BeanPropertyRowMapper<Goods>(Goods.class), gid);
            return goods;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 添加愿望单
     * @param gid
     * @param uid
     * @return
     */
    @Override
    public boolean addWishGood(int gid, int uid) {
        String sql="insert into wish values(null,?,?)";
        int count = jd.update(sql,uid, gid);
        if (count==0){
            return false;
        }else {
            return true;
        }
    }

    /**
     * 是否已经添加
     * @param gid
     * @param uid
     * @return
     */
    @Override
    public boolean isWishGoods(int gid, int uid) {

        try {
            String sql="select * from wish where gid=? and uid=?";
            Wish  wish = jd.queryForObject(sql, new BeanPropertyRowMapper<Wish>(Wish.class), gid, uid);
            return true;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 移除愿望单
     * @param gid
     * @param uid
     * @return
     */
    @Override
    public void removeWishGoods(int gid, int uid) {
        String sql="delete from wish where gid =? and uid=?";
        jd.update(sql,gid,uid);
    }

    /**
     * 查询推荐商品
     * @return
     */
    @Override
    public List<Goods> findRocommend() {
        try {
            String sql="SELECT t1.*,t2.* FROM goods t1 LEFT JOIN picture t2 on t1.pic = t2.pid where isRecommend=?;";
            List<Goods> list = jd.query(sql, new BeanPropertyRowMapper<Goods>(Goods.class), 1);
            return  list;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }

    }
}
