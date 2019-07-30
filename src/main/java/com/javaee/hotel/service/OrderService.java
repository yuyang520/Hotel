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
    SimpleDateFormat compareFormat = new SimpleDateFormat("yyyy-MM-dd");

    public List<OrderListInfo> searchOrderListInfo(String hotelName,String checkInTime,String checkOutTime,int status) {
        OrderListExample orderListExample = new OrderListExample();
        OrderListExample.Criteria criteria = orderListExample.createCriteria();
        criteria.andIdEqualTo(22);
        List<OrderList> orderLists = orderListMapper.selectByExample(orderListExample);
        List<OrderListInfo> orderListInfos = new ArrayList<OrderListInfo>();
        int length = orderLists.size();
        for (int i = 0; i < length; i++) {
            OrderListInfo orderListInfo = new OrderListInfo();
            String orderHotelName = hotelMapper.selectByPrimaryKey(orderLists.get(i).getHotelId())
                    .getHotelChineseName();
            orderListInfo.setHotelChineseName(orderHotelName);
            orderListInfo.setRoomName(roomMapper.selectByPrimaryKey(orderLists.get(i).getRoomId())
                    .getChineseName());
            orderListInfo.setCreateTime(format.format(orderLists.get(i).getRegisterTime()));
            orderListInfo.setCheckInTime(format.format(orderLists.get(i).getCheckIn()));
            orderListInfo.setCheckOutTime(format.format(orderLists.get(i).getCheckOut()));
            orderListInfo.setOrderList(orderLists.get(i));
            if (hotelName==null||hotelName.equals("") || orderHotelName.contains(hotelName)) {
                if(checkInTime==null||checkInTime.equals("") || compareFormat.format(orderLists.get(i).getCheckIn()).compareTo(checkInTime)>=0) {
                    if(checkOutTime==null||checkOutTime.equals("") || compareFormat.format(orderLists.get(i).getCheckOut()).compareTo(checkOutTime)<=0) {
                        if(status==0||status==orderLists.get(i).getStatus()){
                            orderListInfos.add(orderListInfo);
                        }
                    }
                }
            }

        }
        return orderListInfos;
    }

}
