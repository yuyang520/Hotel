package com.javaee.hotel.service;

import com.javaee.hotel.domain.Customer;
import com.javaee.hotel.domain.CustomerInfo;
import com.javaee.hotel.domain.CustomerInfoExample;
import com.javaee.hotel.mapper.CustomerInfoMapper;
import com.javaee.hotel.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private CustomerInfoMapper customerInfoMapper;
    @Autowired
    private CustomerMapper customerMapper;
    public List<CustomerInfo> getNowUser(int id){
        if(id==0){
            return new ArrayList<CustomerInfo>();
        }else {
            CustomerInfoExample example = new CustomerInfoExample();
            example.createCriteria().andIdEqualTo(id);
            return customerInfoMapper.selectByExample(example);
        }
    }
    public int getUserId(HttpSession session){
        if(session.getAttribute("id")==null) {
            return -1;
        }else{
            return Integer.parseInt(session.getAttribute("id").toString());
        }
    }
    public void updateByPK(CustomerInfo customerInfo,int id){
        CustomerInfoExample example = new CustomerInfoExample();
        example.createCriteria().andIdEqualTo(id);
        customerInfoMapper.updateByExample(customerInfo,example);
    }
    public boolean checkUser(int id,String oldpwd) {
        return oldpwd.equals(customerMapper.selectByPrimaryKey(id).getPassword());
    }

    public boolean updatePwd(int id,String pwd) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setPassword(pwd);
        return customerMapper.updateByPrimaryKeySelective(customer)>0;
    }
}