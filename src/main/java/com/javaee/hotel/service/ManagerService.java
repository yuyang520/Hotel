package com.javaee.hotel.service;

import com.javaee.hotel.domain.Hotel;
import com.javaee.hotel.mapper.HotelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {
    @Autowired
    private HotelMapper hotelMapper;
    public int insert(Hotel hotel) {
        return hotelMapper.insertSelective(hotel);
    }
}
