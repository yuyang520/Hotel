package com.javaee.hotel.service;

    import com.javaee.hotel.domain.Customer;
import com.javaee.hotel.domain.CustomerExample;
import com.javaee.hotel.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoginService {
    @Autowired
    CustomerMapper customerMapper;
    public Customer check(String username,String password) {

        CustomerExample customerExample = new CustomerExample();
        CustomerExample.Criteria criteria= customerExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<Customer> result = customerMapper.selectByExample(customerExample);
        if(result.size()==0) {
            return null;
        }
        if(result.get(0).getPassword().equals(password)) {
            return result.get(0);
        }else {
            return null;
        }

    }
}
