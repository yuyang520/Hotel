package com.javaee.hotel.service;

import com.javaee.hotel.domain.Hotel;
import com.javaee.hotel.domain.Manager;
import com.javaee.hotel.domain.ManagerExample;
import com.javaee.hotel.mapper.HotelMapper;
import com.javaee.hotel.mapper.ManagerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {
    @Autowired
    private ManagerMapper managerMapper;

    public List<Manager> managerRespond(){
        ManagerExample example = new ManagerExample();
        return managerMapper.selectByExample(example);
    }

    public Manager getManger(String username){
        Manager manager = managerMapper.selectByPrimaryKey(username);
        return manager;
    }

    public Integer saveManager(Manager manager){
//        System.out.println(manager.getUsername());
//        System.out.println(manager.getPassword());
        if(managerMapper.selectByPrimaryKey(manager.getUsername()) == null){
//            System.out.println(manager.getPassword());
            return managerMapper.insert(manager);
        }else {
            return managerMapper.updateByPrimaryKey(manager);
        }
    }

    public Manager findManagerByPrimaryKey(String username){
        return managerMapper.selectByPrimaryKey(username);
    }

    public void deleteManager(String username){
        managerMapper.deleteByPrimaryKey(username);
    }
}
