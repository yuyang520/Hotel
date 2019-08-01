package com.javaee.hotel.service;

import com.javaee.hotel.domain.Manager;
import com.javaee.hotel.domain.ManagerExample;
import com.javaee.hotel.mapper.ManagerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerLoginService {
    @Autowired
    ManagerMapper managerMapper;

    public Manager check(String username,String password){
        ManagerExample managerExample = new ManagerExample();
        ManagerExample.Criteria criteria = managerExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        System.out.println("");
        List<Manager> result = managerMapper.selectByExample(managerExample);
        if(result.size() == 0){
            return null;
        }
        if(result.get(0).getPassword().equals(password)){
            return result.get(0);
        }else {
            return null;
        }
    }
}
