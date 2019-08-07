package com.javaee.hotel.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.javaee.hotel.domain.*;
import com.javaee.hotel.mapper.HotelMapper;
import com.javaee.hotel.mapper.OrderListMapper;
import com.javaee.hotel.mapper.PriceChangeMapper;
import com.javaee.hotel.mapper.RoomMapper;
import com.javaee.hotel.tool.RoomLeftNumberDeliver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
    @Autowired
    private PriceChangeMapper priceChangeMapper;

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

    public int orderCheck(OrderList orderList,String[] erro) {
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
        int leftNumber = getRoomLeftNumberInCondition(room.getRoomId(),orderList.getCheckIn(),orderList.getCheckOut()) ;
        byte roomNumber = orderList.getRoomNumber();
        if ( room == null ) {
            return false;
        }else if(roomNumber > leftNumber ){
            return false;
        }else if(roomNumber > 5 || roomNumber <= 0 ) {
            return false;
        }
        return true;
    }

    public Date getRegisterDateTime() {
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = new Date();
        return new Date();
    }
    public Date getToday() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            return getDateByString(dateFormat.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }
    public Date getOffsetDate(int offset) {
        return new Date(getToday().getTime() + offset*24*3600*1000);
    }
    public Date getOffsetDate(Date date,int offset) {
        return new Date(date.getTime() + offset*24*3600*1000);
    }
    public float getPrice(Room room,OrderList orderList) {
        Float price =(float)0;
        int day = getOrderDay(orderList);
        PriceChangeExample example = new PriceChangeExample();
        PriceChangeExample.Criteria criteria = example.createCriteria();
        criteria.andRoomIdEqualTo(orderList.getRoomId());
        List<PriceChange> priceChangeList = priceChangeMapper.selectByExample(example);
        int length = priceChangeList.size();
        for(int i = 0 ; i < day ; i ++) {
            boolean target = false;
            for( int j = 0 ; j < length ; j ++) {
                if(getOffsetDate(orderList.getCheckIn(),i).compareTo(priceChangeList.get(j).getDateStart())>=0 &&
                        getOffsetDate(orderList.getCheckIn(),i).compareTo(priceChangeList.get(j).getDateEnd())<0)
                {
                    price+=priceChangeList.get(j).getPrice();
                    target = true;
                }
            }
            if(target == false) {
                price+=room.getPrice();
            }
        }
        return price;
    }
    private boolean checkTimeCheck(OrderList orderList) {
        Date date = new Date();
        if( (orderList.getCheckIn().getTime()+28800000)/(3600*24*1000) < (date.getTime()+28800000)/(3600*24*1000) ) {
            return false;
        }
        if(orderList.getCheckIn().compareTo(orderList.getCheckOut())>=0) {
            return false;
        }else if(( orderList.getCheckOut().getTime()+2880000)/(3600*24*1000)-(date.getTime()+28800000)/(3600*24*1000)>30){
            return false;
        }else {
            return true;
        }
    }
    private int getOrderDay(OrderList orderList) {
        return (int) ( orderList.getCheckOut().getTime()/(3600*24*1000) -
                orderList.getCheckIn().getTime()/(3600*24*1000) );
    }
    public Date getDateByString(String dateString) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date checkDate = dateFormat.parse(dateString);
        return checkDate;
    }
    public boolean addOrderList(OrderList orderList) {
        return (orderListMapper.insertSelective(orderList)>0);
    }

    public List<Room> roomRespond(){
        RoomExample example = new RoomExample();
        return roomMapper.selectByExample(example);
    }


    public Integer saveRoom(Room room){
        if(room.getRoomId() == null){
            return  roomMapper.insert(room);
        }else {
            return roomMapper.updateByPrimaryKey(room);
        }
    }

    public Room findRoomByPrimaryKey(String roomId){

        return roomMapper.selectByPrimaryKey(roomId);
    }

    public void deleteRoomById(String roomId) {

        roomMapper.deleteByPrimaryKey(roomId);
    }
    public int getRoomLeftNumberInCondition(String roomId,Date checkIn,Date checkOut) {
        Room room = roomMapper.selectByPrimaryKey(roomId);
        OrderListExample example = new OrderListExample();
        OrderListExample.Criteria criteria = example.createCriteria();
        criteria.andRoomIdEqualTo(roomId);
        criteria.andStatusLessThanOrEqualTo((byte) 2);
        criteria.andCheckInLessThanOrEqualTo(checkOut);
        criteria.andCheckOutGreaterThanOrEqualTo(checkIn);
        List<OrderList> orderLists = orderListMapper.selectByExample(example);
        int days = (int) (checkOut.getTime()-checkIn.getTime())/(24*3600*1000);
        int orderListNumber = orderLists.size();
        int greatestNum = 0;
        for ( int i = 0 ; i < days ; i ++ ) {
            int numberTemp = 0;
            for( int j = 0 ; j < orderListNumber ; j ++ ) {
                long orderListTempCheckIn = orderLists.get(j).getCheckIn().getTime();
                long orderListTempCheckOut = orderLists.get(j).getCheckOut().getTime();
                long dayOffset = checkIn.getTime()+i*24*3600*1000;
                if( dayOffset >= orderListTempCheckIn && dayOffset < orderListTempCheckOut ) {
                    numberTemp +=orderLists.get(j).getRoomNumber();
                }
            }
            if( greatestNum < numberTemp ) {
                greatestNum = numberTemp;
            }
        }
        return room.getRoomNumber()-greatestNum;
    }
    public List<RoomLeftNumberDeliver> getDeliver(List<Room> roomList) {
        int length = roomList.size();
        List<RoomLeftNumberDeliver> deliverList= new ArrayList<RoomLeftNumberDeliver>();
        Calendar calendar = Calendar.getInstance();
        Date date = getToday();
        for (int i = 0 ; i < length ; i ++ ) {
            RoomLeftNumberDeliver deliver =  new RoomLeftNumberDeliver();
            deliver.setRoomId(roomList.get(i).getRoomId());
            for( int j = 0 ; j < 30 ; j ++ ) {
                calendar.setTime(date);
                calendar.add(Calendar.DATE, j);
                Date dateTemp = new Date(calendar.getTime().getTime()+24*3600*1000);
                deliver.getRoomLeftNumberByDate()[j] =
                        getRoomLeftNumberInCondition(
                                deliver.getRoomId(), calendar.getTime(), dateTemp);
            }
            deliverList.add(deliver);
        }
        return deliverList;

    }
}



