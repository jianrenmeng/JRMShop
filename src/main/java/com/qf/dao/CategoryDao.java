package com.qf.dao;

import com.qf.pojo.Category;

import java.util.List;

public interface CategoryDao {
    public List<Category> findByCid(int cid);
}
