package com.qf.service;

import com.qf.pojo.Address;

import java.util.List;

public interface AddressService {
    boolean addAddress(Address address);

    List<Address> findAllAddress(int uid);

    Address findOneAddress(int aid);

    void removeAddress(int aid);
}
