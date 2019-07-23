package com.javaee.hotel.controller;

import com.javaee.hotel.domain.Hotel;
import com.javaee.hotel.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@Controller
public class ManagerController {
    @Autowired
    private ManagerService managerService;
    @RequestMapping("/manager")
    @ResponseBody
    public int insertHotel() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date checkInDate = dateFormat.parse("2009-06-01 12:00:00");
        Date checkOutDate = dateFormat.parse("2009-06-01 18:00:00");
        Hotel hotel = new Hotel();
        hotel.setHotalEnglishName("jingchengguoji");
        hotel.setHotelChineseName("景程国际酒店");
        hotel.setHotelAddress("天府南路");
        hotel.setHotelCheckinTime(checkInDate);
        hotel.setHotelCheckoutTime(checkOutDate);
        hotel.setHotelContact("11234567890");
        hotel.setHotelLatitude((float)123.123311);
        hotel.setHotelLongitude((float)134.123341);
        hotel.setHotelStars(5);
        hotel.setParking((byte)1);
        hotel.setHotelProfile("这家酒店很好");
        hotel.setHotelRating((float)8.7);
        hotel.setHotelRestRoom(123);
        hotel.setMinHotelPrice((float)897.12);
        hotel.setPicture("hello".getBytes());
        int flag = managerService.insert(hotel);
        System.out.println(flag);
        return flag;
    }
}
