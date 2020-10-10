package com.qf.dao.impl;

import com.qf.dao.CarDao;
import com.qf.pojo.ShopCar;
import com.qf.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CarDaoImpl implements CarDao {
    private JdbcTemplate jd=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<ShopCar> findAllCarGoods(int uid) {
        String sql="SELECT * from shop_car where uid=?";

        try {
            List<ShopCar> list =  jd.query(sql, new BeanPropertyRowMapper<ShopCar>(ShopCar.class), uid);
            return  list;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 删除购物车
     * @param id
     */
    @Override
    public void deleteCar(int id) {
        String sql="delete from shop_car where id=?";
        jd.update(sql,id);
    }

    /**
     * 修改购物车数量
     * @param id
     * @param number
     * @param money
     */
    @Override
    public void updateCarNumber(int id, int number, double money) {
        String sql="update shop_car  set number=? , money=? where id=?";
        jd.update(sql,number,money,id);

    }

    /**
     * 清空购物车
     * @param uid
     */
    @Override
    public void clearAllCar(int uid) {
        String sql="delete from shop_car where uid=?";
        jd.update(sql,uid);

    }

    /**
     * 添加购物车
     * @param gid
     * @param uid
     */
    @Override
    public void addCar(int gid, int uid,int money) {
        String sql="insert into shop_car values(null,?,?,?,?)";
        int update = jd.update(sql, uid, gid, 1,  money);
        System.out.println(update+"====");
    }

    /**
     * 查找是否存在商品了
     * @param gid
     * @param uid
     * @return
     */
    @Override
    public ShopCar findByGidAndUid(int gid,int uid) {
        try {
            String sql="select * from shop_car where gid=? and uid=?";
            ShopCar car = jd.queryForObject(sql, new BeanPropertyRowMapper<ShopCar>(ShopCar.class), gid, uid);
            return car;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ShopCar findOneCar(int id) {
        try {
            String sql="select * from shop_car where id=?";
            ShopCar car = jd.queryForObject(sql, new BeanPropertyRowMapper<ShopCar>(ShopCar.class), id);
            System.out.println("dao中的car="+car);
            return car;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }


    }
}
