package com.javaee.hotel.service;

import com.javaee.hotel.domain.*;
import com.javaee.hotel.mapper.HotelMapper;
import com.javaee.hotel.mapper.OrderListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.javaee.hotel.domain.OrderList;
import com.javaee.hotel.domain.OrderListExample;
import com.javaee.hotel.mapper.OrderListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HotelListService {
    @Autowired
    private HotelMapper hotelMapper;


    public List<Hotel> hotelListRespond(){
        HotelExample example = new HotelExample();
        return hotelMapper.selectByExample(example);
    }

//||hotel.getHotelId()==""
    public Integer saveHotel(Hotel hotel){
//        System.out.println(hotel.getHotelChineseName());
//        System.out.println(hotel.getHotelId());
        if(hotel.getHotelId() == null){
            //System.out.println("inter");
            return  hotelMapper.insert(hotel);

        }else {
            if(hotelMapper.selectByPrimaryKey(hotel.getHotelId()) == null ) {
                return -1;
            }
            return hotelMapper.updateByPrimaryKey(hotel);
        }
    }


    public Hotel findHotelByPrimaryKey(String hotelId){

        return hotelMapper.selectByPrimaryKey(hotelId);
    }

    public void deleteHotelById(String hotelId) {

        hotelMapper.deleteByPrimaryKey(hotelId);
    }


}
