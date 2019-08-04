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
        if(minPrice==6){
            criteria.andMinHotelPriceGreaterThan((float)1000);
        }else if(minPrice==5){
            criteria.andMinHotelPriceBetween((float)500,(float)1000);
        }else if(minPrice==4){
            criteria.andMinHotelPriceBetween((float)300,(float)500);
        }else if(minPrice==3){
            criteria.andMinHotelPriceBetween((float)200,(float)300);
        }else if(minPrice==2){
            criteria.andMinHotelPriceBetween((float)100,(float)200);
        }else if(minPrice==1){
            criteria.andMinHotelPriceBetween((float)0,(float)100);
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
