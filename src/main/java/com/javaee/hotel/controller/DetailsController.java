package com.javaee.hotel.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.javaee.hotel.domain.OrderList;
import com.javaee.hotel.domain.Room;
import com.javaee.hotel.service.RoomService;
import com.javaee.hotel.tool.RoomDetail;
import com.javaee.hotel.tool.RoomItemContent;
import com.javaee.hotel.tool.RoomItemStaticData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/welcome/details")
public class DetailsController {
    @Autowired
    private RoomService roomService;
    @GetMapping(value="")
    public String detailHtml (Model model, @RequestParam("hotelId") String hotelId) {
        List<Room> roomList = roomService.getRoomList(hotelId);
        int length = roomList.size();
        String[] detailList = new String[length];
        for( int i = 0 ; i < length ; i ++ ) {
            detailList[i] = roomList.get(i).getDetail();
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
    @PostMapping(value="/postOrder")
    @ResponseBody
    public boolean postOrder(HttpServletRequest request) {
        OrderList orderList = new OrderList();
        orderList.setName(request.getParameter("name"));
        orderList.setRoomId(request.getParameter("roomId"));
        orderList.setRoomNumber(Byte.parseByte(request.getParameter("roomNumber")));
        orderList.setIdentify(request.getParameter("identify"));
        orderList.setConnectPhone(request.getParameter("connectPhone"));
        orderList.setId(Integer.parseInt(request.getParameter("id")));
        orderList.setHotelId(request.getParameter("hotelId"));
        try {
            orderList.setCheckIn(roomService.getDateByString(request.getParameter("checkIn")));
            orderList.setCheckOut(roomService.getDateByString(request.getParameter("checkOut")));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        roomService.addOrderList(orderList);
//
        return true;
    }


}
