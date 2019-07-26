package com.javaee.hotel.service;

import com.javaee.hotel.domain.Hotel;
import com.javaee.hotel.domain.HotelExample;
import com.javaee.hotel.mapper.HotelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MapseachService {
    @Autowired
    private HotelMapper hotelMapper;

    public List<Hotel> search(String keyword){
        HotelExample example=new HotelExample();
        example.createCriteria().andHotelChineseNameLike("%"+keyword+"%");
        return hotelMapper.selectByExample(example);
    }

}
