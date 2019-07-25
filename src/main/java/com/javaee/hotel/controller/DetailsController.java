package com.javaee.hotel.controller;

import com.javaee.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/welcome/details")
public class DetailsController {
    @Autowired
    private RoomService roomService;
    @GetMapping(value="")
    public String detailHtml (Model model) {
        model.addAttribute("roomList",roomService.getRoomList());
        return "details";
    }
}
