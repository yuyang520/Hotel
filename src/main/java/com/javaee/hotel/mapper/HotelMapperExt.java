package com.javaee.hotel.mapper;

import com.javaee.hotel.domain.Hotel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HotelMapperExt {
    List<Hotel> hotelsearch(@Param("keyword") String keyword);
}

