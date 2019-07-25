package com.javaee.hotel.service;

import com.javaee.hotel.mapper.HotelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeyWordSearchController {
    @Autowired
    private HotelMapper hotelMapper;

}
