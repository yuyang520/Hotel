package com.javaee.hotel.service;

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
    public int checkPassword(String password) {
        // 判断密码是否为ASCII码
        byte[] passwordByte = password.getBytes();
        byte lower = '!';
        byte upper = '~';

        if ( passwordByte.length != password.length()) {
            return 1;
        }

        // 判断密码是否仅为数字，字母和一些常用字符
        for ( byte i : passwordByte) {
            if(Byte.compare(i,lower)<0 && (Byte.compare(upper,i))<0)
                return 2;
        }

        // 判断密码长度是否大于16
        if ( password.length() > 16) {
            return 3;
        }

        // 判断密码长度是否小于8
        if ( password.length() < 8) {
            return 4;
        }

        return 0;
    }
}

