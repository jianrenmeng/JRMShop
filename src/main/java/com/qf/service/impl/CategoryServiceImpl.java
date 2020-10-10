package com.qf.service.impl;

import com.qf.dao.CategoryDao;
import com.qf.dao.impl.CategoryDaoImpl;
import com.qf.pojo.Category;
import com.qf.service.CategoryService;
import com.qf.utils.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDao dao=new CategoryDaoImpl();
    @Override
    public List<Category> findByCid(int cid) {
        //先从redis中查
        Jedis jedis = JedisUtil.getJedis();
//        Set<String> smartCategory = jedis.zrange("category", 0, -1);
        Set<Tuple> category = jedis.zrangeWithScores("category"+cid, 0, -1);
        List<Category> sl =null;
        //redis没有 从数据库中查
        if (category ==null || category.size()==0){
            System.out.println("从数据库中查");
            sl = dao.findByCid(cid);
            for (int i = 0; i <sl.size(); i++) {
                jedis.zadd("category"+cid,sl.get(i).getCid(),sl.get(i).getCname());
            }
        }else {
            System.out.println("从redis中查");
            sl=new ArrayList<Category>();
            for (Tuple  tuple : category) {
                Category c = new Category();
                c.setCid((int) tuple.getScore());
                c.setCname(tuple.getElement());
                sl.add(c);
            }
        }
        return sl;
    }
}
