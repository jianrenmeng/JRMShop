package com.qf.dao.impl;

import com.qf.dao.AddressDao;
import com.qf.pojo.Address;
import com.qf.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.rmi.server.UID;
import java.util.List;

public class AddressDaoImpl  implements AddressDao {
    private JdbcTemplate jd=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public boolean addAddress(Address address) {
        String sql="insert into shop_address values(null,?,?,?,?,?,?)";
        int count = jd.update(sql, address.getAname(), address.getAemail(), address.getTelphone(), address.getCity(), address.getDetailaddress(), address.getUid());
        if (count==1){
            return true;
        }
        return false;
    }

    @Override
    public List<Address> findAllAddress(int uid) {
        String sql="select * from shop_address where uid= ?";
        try {
            List<Address> list = jd.query(sql, new BeanPropertyRowMapper<Address>(Address.class), uid);
            return list;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Address findOneAddress(int aid) {
        try {
            String sql="select * from shop_address where aid= ?";
            Address address = jd.queryForObject(sql, new BeanPropertyRowMapper<>(Address.class),aid);
            return address;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public void removeAdddress(int aid) {
        try {
            String sql="delete from shop_address where aid=?";
            jd.update(sql,aid);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
}
