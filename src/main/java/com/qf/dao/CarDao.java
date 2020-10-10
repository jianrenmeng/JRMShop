package com.qf.dao;

import com.qf.pojo.ShopCar;

import java.util.List;

public interface CarDao {
    List<ShopCar> findAllCarGoods(int uid);

    void deleteCar(int id);

    void updateCarNumber(int id, int number, double money);

    void clearAllCar(int uid);

    void addCar(int gid, int uid,int money);

    ShopCar findByGidAndUid(int gid,int uid);

    ShopCar findOneCar(int id);
}
