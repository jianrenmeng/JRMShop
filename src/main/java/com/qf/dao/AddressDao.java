package com.qf.dao;

import com.qf.pojo.Address;

import java.util.List;

public interface AddressDao {
    boolean addAddress(Address address);

    List<Address> findAllAddress(int uid);

    Address findOneAddress(int aid);

    void removeAdddress(int aid);
}
