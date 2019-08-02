package com.javaee.hotel.service;

import com.javaee.hotel.domain.Hotel;
import com.javaee.hotel.domain.HotelExample;
import com.javaee.hotel.mapper.HotelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    @Autowired
    private HotelMapper hotelMapper;

    public List<Hotel> searchh(String keyword,float minPrice,String city,Integer star){
        HotelExample example=new HotelExample();
        HotelExample.Criteria criteria=example.createCriteria();
        if(keyword!=""&&keyword!=null) {
            criteria.andHotelChineseNameLike("%" + keyword + "%");
        }
        if(minPrice!=7){
            criteria.andMinHotelPriceLessThanOrEqualTo(minPrice);
        }
        if(city!="" &&keyword!=null){
            criteria.andHotelAddressLike("%"+city+"%");
        }
        if(star!=6) {
            criteria.andHotelStarsEqualTo(star);
        }
        return hotelMapper.selectByExample(example);
    }

}
