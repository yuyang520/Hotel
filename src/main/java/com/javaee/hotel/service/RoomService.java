package com.javaee.hotel.service;

import com.javaee.hotel.domain.Hotel;
import com.javaee.hotel.domain.HotelExample;
import com.javaee.hotel.domain.Room;
import com.javaee.hotel.domain.RoomExample;
import com.javaee.hotel.mapper.HotelMapper;
import com.javaee.hotel.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private HotelMapper hotelMapper;
    public void addRoom(Room room) {
        roomMapper.insertSelective(room);
    }
    public List<Hotel> getHotelList() {
        HotelExample example = new HotelExample();
        HotelExample.Criteria criteris = example.createCriteria();
        return hotelMapper.selectByExample(example);
    }
    public List<Room> getRoomList() {
        RoomExample example = new RoomExample();
        RoomExample.Criteria criteris =  example.createCriteria();
        criteris.andHotelIdIsNotNull();
        return roomMapper.selectByExample(example);
    }
}
