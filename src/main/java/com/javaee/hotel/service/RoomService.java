package com.javaee.hotel.service;

import com.javaee.hotel.domain.*;
import com.javaee.hotel.mapper.HotelMapper;
import com.javaee.hotel.mapper.OrderListMapper;
import com.javaee.hotel.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    public boolean orderCheck(OrderList orderList) {
        boolean connectPhoneCheckRes = connectPhoneCheck(orderList.getConnectPhone());
        boolean identifyCheckRes = identifyCheck(orderList.getIdentify());
        if ( connectPhoneCheckRes != true  ) {
            return false;
        }
        if ( identifyCheckRes != true ) {
            return false;
        }
        return true;
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

    public Date getDateByString(String dateString) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date checkDate = dateFormat.parse(dateString);
        return checkDate;
    }
    public boolean addOrderList(OrderList orderList) {
        return (orderListMapper.insertSelective(orderList)>0);
    }
}
