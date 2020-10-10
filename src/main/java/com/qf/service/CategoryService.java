package com.qf.service;

import com.qf.pojo.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> findByCid(int cid);
}
