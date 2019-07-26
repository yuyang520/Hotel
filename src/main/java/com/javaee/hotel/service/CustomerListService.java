package com.javaee.hotel.service;


import com.javaee.hotel.domain.CustomerInfo;
import com.javaee.hotel.domain.CustomerInfoExample;
import com.javaee.hotel.mapper.CustomerInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerListService {
    @Autowired
    private CustomerInfoMapper customerInfoMapper;

    public List<CustomerInfo> customerInfoRespond(){
        CustomerInfoExample example = new CustomerInfoExample();
        return customerInfoMapper.selectByExample(example);
    }


}
