package com.qf.dao.impl;

import com.qf.dao.CategoryDao;
import com.qf.pojo.Category;
import com.qf.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class CategoryDaoImpl  implements CategoryDao {
    private JdbcTemplate jd=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Category> findByCid(int cid) {
        String sql="select * from category where pid=?";

        List<Category> list = jd.query(sql, new BeanPropertyRowMapper<Category>(Category.class),cid);

        return list;
    }
}
