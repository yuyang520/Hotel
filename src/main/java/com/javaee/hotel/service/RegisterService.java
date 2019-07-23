package com.javaee.hotel.service;

import com.javaee.hotel.domain.Customer;
import com.javaee.hotel.domain.CustomerExample;
import com.javaee.hotel.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    @Autowired
    private CustomerMapper customerMapper;
    public boolean checkUsername(String username) {
        CustomerExample example = new CustomerExample();
        CustomerExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        return (customerMapper.countByExample(example)>0);
    }
    public int checkStr(String str, int min, int max) {
        // 判断是否为ASCII码
        byte[] strByte = str.getBytes();
        byte lower = '!';
        byte upper = '~';

        if ( strByte.length != str.length()) {
            return 1;
        }

        // 判断是否仅为数字，字母和一些常用字符
        for ( byte i : strByte) {
            if(Byte.compare(i,lower)<0 && (Byte.compare(upper,i))<0)
                return 2;
        }

        // 判断长度是否大于16
        if ( str.length() > max) {
            return 3;
        }

        // 判断长度是否小于8
        if ( str.length() < min) {
            return 4;
        }

        return 0;
    }

    public void register(Customer customer) {
        customerMapper.insert(customer);
    }
}

