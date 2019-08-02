package com.javaee.hotel.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.javaee.hotel.domain.OrderList;
import com.javaee.hotel.domain.Room;
import com.javaee.hotel.service.RoomService;
import com.javaee.hotel.tool.RoomDetail;
import com.javaee.hotel.tool.RoomItemContent;
import com.javaee.hotel.tool.RoomItemStaticData;
import com.javaee.hotel.tool.RoomLeftNumberDeliver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/welcome/details")
public class DetailsController {
    @Autowired
    private RoomService roomService;
    @GetMapping(value="")
    public String detailHtml (Model model, @RequestParam("hotelId") String hotelId) {
        List<Room> roomList = roomService.getRoomList(hotelId);
        model.addAttribute("leftNumberDeliver",roomService.getDeliver(roomList));
        int length = roomList.size();
        String[] detailList = new String[length];
        for( int i = 0 ; i < length ; i ++ ) {
            detailList[i] = roomList.get(i).getDetail();
            Room room = roomList.get(i);
            Date date = roomService.getToday();
            room.setRoomNumber(roomService.getRoomLeftNumberInCondition(room.getRoomId(),date,roomService.getOffsetDate(1)));
        }
        List<RoomItemContent> roomItemContentList = new ArrayList<RoomItemContent>();
        RoomItemStaticData roomItemStaticData = new RoomItemStaticData();
        for( int i = 0 ; i < length ; i ++ ) {
            JSONObject jsonObject = JSON.parseObject(detailList[i]);
            roomItemContentList.add(roomItemStaticData.analyseItemContent(jsonObject));
        }
        List<RoomDetail> roomDetailList = new ArrayList<RoomDetail>();
        for ( int i = 0 ; i < length ; i ++ ) {
            roomDetailList.add(new RoomDetail(roomList.get(i),roomItemContentList.get(i)));
        }
        model.addAttribute("hotelId",hotelId);
        model.addAttribute("roomDetailList",roomDetailList);
        return "details";
    }
    @PostMapping(value="/postOrder",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public HashMap postOrder(HttpServletRequest request, HttpSession session) {
        HashMap hashMap = new HashMap();
        OrderList orderList = new OrderList();
        if(session.getAttribute("id") == null) {
            hashMap.put("isLogin",false);
            return hashMap;
        }else {
            hashMap.put("isLogin",true);
            orderList.setId(Integer.parseInt(session.getAttribute("id").toString()));
        }
        orderList.setName(request.getParameter("name"));
        orderList.setRoomId(request.getParameter("roomId"));
        orderList.setRoomNumber(Byte.parseByte(request.getParameter("roomNumber")));
        orderList.setIdentify(request.getParameter("identify"));
        orderList.setConnectPhone(request.getParameter("connectPhone"));
        orderList.setHotelId(request.getParameter("hotelId"));
        orderList.setStatus((byte)1);
        try {
            orderList.setCheckIn(roomService.getDateByString(request.getParameter("checkIn")));
            orderList.setCheckOut(roomService.getDateByString(request.getParameter("checkOut")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String[] roomNoReceive = new String[1];
        roomNoReceive[0] = "";
        String[] erro = new String[1];
        erro[0] = "";
        int checkNumber = roomService.orderCheck(orderList,erro);
        System.out.println("checkNumber:"+checkNumber);
        System.out.println("roomNoReceive:"+roomNoReceive[0]);
        if( checkNumber == 0) {
            roomService.addOrderList(orderList);
            roomNoReceive[0] = "预定成功";
            hashMap.put("roomNoReceive",roomNoReceive[0]);
            return hashMap;
        }else {
            hashMap.put("roomNoReceive","");
            hashMap.put("error",erro[0]);
            return hashMap;
        }
    }
    @PostMapping(value="/getLeftRoomNumber")
    @ResponseBody
    public int getLeftRoomNumber(HttpServletRequest request) {
        String roomId = request.getParameter("roomId");
        try {
            Date checkIn = roomService.getDateByString(request.getParameter("checkIn"));
            Date checkOut = roomService.getDateByString(request.getParameter("checkIn"));
            return roomService.getRoomLeftNumberInCondition(roomId,checkIn,checkOut);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }


}
