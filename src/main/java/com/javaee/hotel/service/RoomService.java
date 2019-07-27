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
        return hotelMapper.selectByExample(example);
    }
    public List<Room> getRoomList(String hotelId) {
        RoomExample example = new RoomExample();
        if (hotelId == null) {
            return roomMapper.selectByExample(example);
        }
        RoomExample.Criteria criteria = example.createCriteria();
        criteria.andHotelIdEqualTo(hotelId);
        return roomMapper.selectByExample(example);
    }
}
