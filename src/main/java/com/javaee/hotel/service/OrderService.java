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

    public List<OrderListInfo> searchOrderListInfo( int userId,String hotelName,String checkInTime,String checkOutTime,int status) {
        OrderListExample orderListExample = new OrderListExample();
        OrderListExample.Criteria criteria = orderListExample.createCriteria();
        criteria.andIdEqualTo(userId);
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
            orderListInfo.setCheckInTime(compareFormat.format(orderLists.get(i).getCheckIn()));
            orderListInfo.setCheckOutTime(compareFormat.format(orderLists.get(i).getCheckOut()));
            int statusInDB = 0;
            if(orderLists.get(i).getStatus()!=null) {
                statusInDB = orderLists.get(i).getStatus();
            }
            if(statusInDB==(byte)2){
                changeStatus(orderLists.get(i));
            }
            orderListInfo.setOrderList(orderLists.get(i));
            if (hotelName==null||hotelName.equals("") || orderHotelName.contains(hotelName)) {
                if(checkInTime==null||checkInTime.equals("") || compareFormat.format(orderLists.get(i).getCheckIn()).compareTo(checkInTime)>=0) {
                    if(checkOutTime==null||checkOutTime.equals("") || compareFormat.format(orderLists.get(i).getCheckOut()).compareTo(checkOutTime)<=0) {
                        if((statusInDB >= 1) && (statusInDB <= 4) && ((status == 0) || (status == statusInDB))){
                            orderListInfos.add(orderListInfo);
                        }
                    }
                }
            }

        }
        return orderListInfos;
    }
    public boolean changeStatus(OrderList orderList){
        Date now = new Date();
        String nows = compareFormat.format(now);
        String orderDate = compareFormat.format(orderList.getCheckOut());
        if(nows.compareTo(orderDate)>=0) {
            orderList.setStatus((byte)3);
            orderListMapper.updateByPrimaryKey(orderList);
        }
        return true;
    }
}
