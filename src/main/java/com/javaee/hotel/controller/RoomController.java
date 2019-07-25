package com.javaee.hotel.controller;

import com.javaee.hotel.domain.Hotel;
import com.javaee.hotel.domain.Room;
import com.javaee.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RoomController {
    @Autowired
    private RoomService roomService;
    @GetMapping("/roomManage")
    public String roomManageHtml(Model model) {
        model.addAttribute("hotelidList",roomService.getHotelList());
        model.addAttribute("roomList",roomService.getRoomList());
        return "/roomManage";
    }
    @PostMapping("/roomManage")
    public String roomManageInsert(Model model, Room room) {
        roomService.addRoom(room);
        System.out.println(room.getChineseName());
        model.addAttribute("hotelidList",roomService.getHotelList());
        model.addAttribute("roomList",roomService.getRoomList());
        return "/roomManage";
    }
}
