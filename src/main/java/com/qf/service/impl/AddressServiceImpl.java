package com.qf.service.impl;

import com.qf.dao.AddressDao;
import com.qf.dao.impl.AddressDaoImpl;
import com.qf.pojo.Address;
import com.qf.service.AddressService;

import java.util.List;

public class AddressServiceImpl implements AddressService {
    private AddressDao  dao=new AddressDaoImpl();
    @Override
    public boolean addAddress(Address address) {

        boolean flag=dao.addAddress(address);
        return flag;
    }

    @Override
    public List<Address> findAllAddress(int uid) {
       List<Address> list= dao.findAllAddress(uid);
        return list;
    }

    @Override
    public Address findOneAddress(int aid) {
        Address address=dao.findOneAddress(aid);
        return address;
    }

    @Override
    public void removeAddress(int aid) {
        dao.removeAdddress(aid);
    }
}
