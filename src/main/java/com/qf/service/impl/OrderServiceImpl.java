package com.qf.service.impl;

import com.qf.dao.AddressDao;
import com.qf.dao.CarDao;
import com.qf.dao.GoodsDao;
import com.qf.dao.OrderDao;
import com.qf.dao.impl.AddressDaoImpl;
import com.qf.dao.impl.CarDaoImpl;
import com.qf.dao.impl.GoodsDaoImpl;
import com.qf.dao.impl.OrderDaoImpl;
import com.qf.pojo.Address;
import com.qf.pojo.Goods;
import com.qf.pojo.Order;
import com.qf.pojo.ShopCar;
import com.qf.service.OrderService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * 订单 service层
 */
public class OrderServiceImpl implements OrderService {

    private OrderDao dao=new OrderDaoImpl();
    private CarDao cdao=new CarDaoImpl();
    private  AddressDao adao=new AddressDaoImpl();
    private  GoodsDao goodsDao = new GoodsDaoImpl();

    /**
     * 添加订单
     * @param id
     * @param aid
     */
    @Override
    public void addOrder(int id, int aid) {

        Order order = new Order();
        //定义 order 中oid  和 time
        DateTimeFormatter FORMAT_FOURTEEN = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String oid = FORMAT_FOURTEEN.format(LocalDateTime.now());
        DateTimeFormatter FORMAT_NINETEEN = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String time = FORMAT_NINETEEN.format(LocalDateTime.now());
        order.setOid(oid);
        order.setTime(time);
        order.setStatu(1);
        //根据id查找购物车中的商品 的 uid  和 gid

        ShopCar car = cdao.findOneCar(id);

        int gid = car.getGid();
        int uid = car.getUid();
        //查询totalmoney
        Goods goods = goodsDao.findGoodsByGid(gid);
        car.setGoods(goods);
        double totalmoney=car.getMoney()+goods.getFare();
        order.setTotalmoney(totalmoney);
        //设置地址
        Address address = adao.findOneAddress(aid);
        String newaddress=address.getCity()+""+address.getDetailaddress();
        order.setAddress(newaddress);

        dao.addOrder(order,uid,gid);
    }

    @Override
    public List<Order> findOrderByUid(int uid) {
        List<Order> list = dao.findOrderByuid(uid);
        for (int i = 0; i < list.size(); i++) {
            int gid = list.get(i).getGid();
            Goods goods = goodsDao.findGoodsByGid(gid);
            list.get(i).setGoods(goods);
        }
        System.out.println("service"+list.toString());
        return list;
    }


}
