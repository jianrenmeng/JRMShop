package com.qf.dao.impl;

import com.qf.dao.WishListDao;
import com.qf.pojo.WishList;
import com.qf.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class WishListDaoImpl implements WishListDao {

    private JdbcTemplate jd=new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 查看用户的所有愿望单
     * @param uid
     * @return
     */
    @Override
    public List<WishList> findAllWishGoods(int uid) {
        String sql="SELECT\n" +
                "  t2.id,t1.gid,t1.price,t1.gname,t1.normalpic \n" +
                "FROM\n" +
                " (SELECT t1.*,t2.* FROM goods t1 LEFT JOIN picture t2 on t1.pic = t2.pid ) t1,\n" +
                "  wish t2\n" +
                "where  \n" +
                "  t1.gid=t2.gid and uid=?";
        try {
            List<WishList> list = jd.query(sql, new BeanPropertyRowMapper<WishList>(WishList.class), uid);
            return list;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
