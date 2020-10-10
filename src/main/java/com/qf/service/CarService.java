package com.qf.service;

import com.qf.pojo.ShopCar;

import java.util.List;

public interface CarService {
    List<ShopCar> findAllCarGoods(int uid);

    void deleteCar(String id);

    void updateCarNumber(int id, int number, int price);

    void clearAllCar(int uid);

    void addCar(int gid, int uid);

    ShopCar findOneCar(int id);
}
