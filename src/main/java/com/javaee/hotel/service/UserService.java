package com.javaee.hotel.service;

import com.javaee.hotel.domain.CustomerInfo;
import com.javaee.hotel.domain.CustomerInfoExample;
import com.javaee.hotel.mapper.CustomerInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private CustomerInfoMapper customerInfoMapper;

    public List<CustomerInfo> getNowUser(int id){
        if(id==0){
            return new ArrayList<CustomerInfo>();
        }else {
            CustomerInfoExample example = new CustomerInfoExample();
            example.createCriteria().andIdEqualTo(id);
            return customerInfoMapper.selectByExample(example);
        }
    }
}