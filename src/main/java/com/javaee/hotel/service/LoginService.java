package com.javaee.hotel.service;

    import com.javaee.hotel.domain.Customer;
import com.javaee.hotel.domain.CustomerExample;
    import com.javaee.hotel.domain.CustomerInfo;
    import com.javaee.hotel.domain.CustomerInfoExample;
    import com.javaee.hotel.mapper.CustomerInfoMapper;
    import com.javaee.hotel.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoginService {
    @Autowired
    CustomerMapper customerMapper;
    @Autowired
    CustomerInfoMapper customerInfoMapper;
    public Customer check(String username,String password) {

        CustomerExample customerExample = new CustomerExample();
        CustomerExample.Criteria criteria= customerExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<Customer> result = customerMapper.selectByExample(customerExample);
        if(result.size()==0) {
            CustomerInfoExample customerInfoExample = new CustomerInfoExample();
            CustomerInfoExample.Criteria criteria1 = customerInfoExample.createCriteria();
            criteria1.andEmailEqualTo(username);
            List<CustomerInfo> customerInfos = customerInfoMapper.selectByExample(customerInfoExample);
            if(customerInfos.size()==0) {
                return null;
            }
            int id = customerInfos.get(0).getId();
            Customer customer = customerMapper.selectByPrimaryKey(id);
            if(customer.getPassword().equals(password)) {
                return customer;
            }
            return null;
        }
        if(result.get(0).getPassword().equals(password)) {
            return result.get(0);
        }else {
            return null;
        }

    }
}
