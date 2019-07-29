package com.javaee.hotel.service;


import com.javaee.hotel.domain.Customer;
import com.javaee.hotel.domain.CustomerExample;
import com.javaee.hotel.domain.CustomerInfo;
import com.javaee.hotel.domain.CustomerInfoExample;
import com.javaee.hotel.mapper.CustomerInfoMapper;
import com.javaee.hotel.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class CustomerListService {
    @Autowired
    private CustomerInfoMapper customerInfoMapper;
    @Autowired
    private CustomerMapper customerMapper;

    public List<CustomerInfo> customerInfoRespond(){
        CustomerInfoExample example = new CustomerInfoExample();
        return customerInfoMapper.selectByExample(example);
    }


    public Integer saveCustomerList(CustomerInfo customerInfo){
        return customerInfoMapper.insert(customerInfo);
    }

    public Customer findCustomerInfoByPrimaryKey(int id){

        return customerMapper.selectByPrimaryKey(id);
    }

    public CustomerInfo getCustomerInfo(int id) {
        CustomerInfoExample example = new CustomerInfoExample();
        CustomerInfoExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        List<CustomerInfo> customerInfoList = customerInfoMapper.selectByExample(example);
        if(customerInfoList.size()!=0)
        return customerInfoList.get(0);
        else {
            return null;
        }

    }

    public void deleteCustomer(int id){
        CustomerInfoExample example = new CustomerInfoExample();
        CustomerInfoExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        List<CustomerInfo> customerInfoList = customerInfoMapper.selectByExample(example);
        customerInfoMapper.deleteByExample(example);
    }
}
