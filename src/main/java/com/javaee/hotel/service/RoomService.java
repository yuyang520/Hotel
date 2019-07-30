package com.javaee.hotel.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.javaee.hotel.domain.*;
import com.javaee.hotel.mapper.HotelMapper;
import com.javaee.hotel.mapper.OrderListMapper;
import com.javaee.hotel.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.javaee.hotel.tool.IdentifyCheck;
import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomMapper roomMapper;

    @Autowired
    private OrderListMapper orderListMapper;

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

    public int orderCheck(OrderList orderList,String[] roomNoReceive,String[] erro) {
        Room room = roomMapper.selectByPrimaryKey(orderList.getRoomId());
        boolean connectPhoneCheckRes = connectPhoneCheck(orderList.getConnectPhone());
        boolean identifyCheckRes = identifyCheck(orderList.getIdentify());
        if ( connectPhoneCheckRes != true  ) {
            erro[0] = "电话号码不正确";
            return 1;
        }
        if ( identifyCheckRes != true ) {
            erro[0] = "身份证不正确";
            return 2;
        }
        if ( roomCheck(room,orderList) != true) {
            erro[0] = "房间预定错误";
            return 3;
        }
        if ( checkTimeCheck(orderList) != true) {
            erro[0] = "预订时间错误";
            return 4;
        }
        orderList.setPrice(getPrice(room,orderList));
        orderList.setRegisterTime(getRegisterDateTime());
        roomNoReceive[0] = getRoomNo(room,orderList);
        orderList.setRoomNo(roomNoReceive[0]);
        return 0;
    }
    private boolean connectPhoneCheck(String connectPhone) {
        Pattern p = null;
        Matcher m = null;
        boolean isMatch = false;
//        String regex1 = "^[1][3,4,5,7,8][0-9]{9}$";
        String regex2 = "^((13[0-9])|(14[579])|(15([0-3,5-9]))|(16[6])|(17[0135678])|(18[0-9]|19[89]))\\d{8}$";
        p = Pattern.compile(regex2);
        m = p.matcher(connectPhone);
        isMatch = m.matches();
        return isMatch;
    }
    private boolean identifyCheck(String identify) {
        boolean result = false;
        if (identify == null) {
            return result;
        }
        try {
            result=(IdentifyCheck.IDCardValidate(identify)!=null);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
    private boolean roomCheck(Room room,OrderList orderList) {
        int leftNumber = room.getLeftNumber();
        byte roomNumber = orderList.getRoomNumber();
        if ( room == null ) {
            return false;
        }else if(roomNumber > leftNumber){
            return false;
        }else if(roomNumber > 5 || roomNumber <= 0 ) {
            return false;
        }
        return true;
    }
    public String getRoomNo(Room room,OrderList orderList) {
        JSONObject jsonObject = JSON.parseObject(room.getRoomNo());
        JSONArray roomList = jsonObject.getJSONArray("roomList");
        JSONArray status = jsonObject.getJSONArray("status");
        int counter = 0 ;
        int roomListLength = roomList.size();
        String roomNo = "";
        for ( int i = 0 ; i < roomListLength ; i ++ ) {
            if( Integer.parseInt(status.get(i).toString()) == 0 ){
                roomNo = roomNo + roomList.get(i).toString() +" ";
                status.set(i,1);
                counter++;
                if(counter == orderList.getRoomNumber()) {
                    break;
                }
            }
        }
        int leftNumber = room.getLeftNumber() - counter;
        room.setRoomNo(jsonObject.toString());
        room.setLeftNumber(leftNumber);
        roomMapper.updateByPrimaryKey(room);
        return roomNo;
    }
    public Date getRegisterDateTime() {
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = new Date();
        return new Date();
    }
    public float getPrice(Room room,OrderList orderList) {
        return room.getPrice()*getOrderDay(orderList);
    }
    private boolean checkTimeCheck(OrderList orderList) {
        Date date = new Date();
        if( (orderList.getCheckIn().getTime()+28800000)/(3600*24*1000) < (date.getTime()+28800000)/(3600*24*1000) ) {
            return false;
        }
        if(orderList.getCheckIn().compareTo(orderList.getCheckOut())>0) {
            return false;
        }else {
            return true;
        }
    }
    private int getOrderDay(OrderList orderList) {
        return (int) ( orderList.getCheckOut().getTime()/(3600*24) -
                orderList.getCheckIn().getTime()/(3600*24) + 1 );
    }
    public Date getDateByString(String dateString) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date checkDate = dateFormat.parse(dateString);
        return checkDate;
    }
    public boolean addOrderList(OrderList orderList) {
        return (orderListMapper.insertSelective(orderList)>0);
    }
}
