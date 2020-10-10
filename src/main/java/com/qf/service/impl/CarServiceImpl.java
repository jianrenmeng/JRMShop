package com.qf.service.impl;

import com.qf.dao.CarDao;
import com.qf.dao.GoodsDao;
import com.qf.dao.impl.CarDaoImpl;
import com.qf.dao.impl.GoodsDaoImpl;
import com.qf.pojo.Goods;
import com.qf.pojo.ShopCar;
import com.qf.service.CarService;
import com.sun.mail.imap.protocol.ID;

import javax.servlet.annotation.WebServlet;
import java.util.ArrayList;
import java.util.List;


public class CarServiceImpl implements CarService {
    private CarDao dao = new CarDaoImpl();
    private GoodsDao gdao = new GoodsDaoImpl();

    @Override
    public List<ShopCar> findAllCarGoods(int uid) {
        List<ShopCar> list = dao.findAllCarGoods(uid);
        List<ShopCar> newlist = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            ShopCar shopCar = list.get(i);
            int gid = shopCar.getGid();
            Goods goods = gdao.findGoodsByGid(gid);
            shopCar.setGoods(goods);
            newlist.add(shopCar);
        }
        return newlist;
    }

    /**
     * 删除购物车
     *
     * @param sid
     */
    @Override
    public void deleteCar(String sid) {
        int id = Integer.parseInt(sid);
        dao.deleteCar(id);

    }

    /**
     * 修改购物车数量
     *
     * @param id
     * @param number
     * @param price
     */
    @Override
    public void updateCarNumber(int id, int number, int price) {
        double money = number * price;
        dao.updateCarNumber(id, number, money);

    }

    /**
     * 清空购物车
     *
     * @param uid
     */
    @Override
    public void clearAllCar(int uid) {
        dao.clearAllCar(uid);
    }

    /**
     * 添加购物车
     *
     * @param uid
     */
    @Override
    public void addCar(int gid, int uid) {
        //先看有无添加
        ShopCar car = dao.findByGidAndUid(gid, uid);
        System.out.println(car + "car");
        Goods goods = gdao.findGoodsByGid(gid);
        String str_price = goods.getPrice();
        int price = Integer.parseInt(str_price);
        if (car != null) {
            //说明已经有了 就加数量
            updateCarNumber(car.getId(), car.getNumber() + 1, price);
        } else {
            dao.addCar(gid, uid, price);
        }
    }

    @Override
    public ShopCar findOneCar(int id) {
        ShopCar car=dao.findOneCar(id);
        //找到的good对象
        int gid = car.getGid();
        Goods goods = gdao.findGoodsByGid(gid);
        car.setGoods(goods);
        return car;
    }
}
