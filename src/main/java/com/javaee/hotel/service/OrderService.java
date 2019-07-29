package com.javaee.hotel.service;

import com.javaee.hotel.domain.OrderList;
import com.javaee.hotel.domain.OrderListExample;
import com.javaee.hotel.mapper.HotelMapper;
import com.javaee.hotel.mapper.OrderListMapper;
import com.javaee.hotel.mapper.RoomMapper;
import com.javaee.hotel.tool.OrderListInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class OrderService {
    @Autowired
    private OrderListMapper orderListMapper;
    @Autowired
    private HotelMapper hotelMapper;
    @Autowired
    private RoomMapper roomMapper;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public List<OrderListInfo> getOrderListInfo(){
        List<OrderList> orderLists=orderListMapper.selectByExample(new OrderListExample());
        List<OrderListInfo> orderListInfos=new ArrayList<OrderListInfo>();
        int length=orderLists.size();
        for(int i=0;i<length;i++) {
            OrderListInfo orderListInfo=new OrderListInfo();
            orderListInfo.setHotelChineseName(
                    hotelMapper.selectByPrimaryKey(orderLists.get(i).getHotelId())
                            .getHotelChineseName()
            );
            System.out.println(orderListInfo.getHotelChineseName());
            orderListInfo.setRoomName(
                    roomMapper.selectByPrimaryKey(orderLists.get(i).getRoomId())
                            .getChineseName()
            );
            orderListInfo.setCreateTime(format.format(orderLists.get(i).getRegisterTime()));
            orderListInfo.setCheckInTime(format.format(orderLists.get(i).getCheckIn()));
            orderListInfo.setCheckOutTime(format.format(orderLists.get(i).getCheckOut()));
            orderListInfo.setOrderList(orderLists.get(i));
            orderListInfos.add(orderListInfo);
        }
        System.out.println(orderListInfos);
        return orderListInfos;
    }
}
