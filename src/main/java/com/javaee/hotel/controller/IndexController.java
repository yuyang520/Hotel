package com.javaee.hotel.controller;

import com.javaee.hotel.service.RoomService;
import com.javaee.hotel.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("welcome")
public class IndexController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private SearchService searchService;

    @GetMapping(value = "")
    public String showIndex (Model model) {
        model.addAttribute("hotels", roomService.getHotelList());
        return "index";
    }
    @PostMapping(value = "")
    public String searchHotel(HttpServletRequest request, Model model){
        String hotelname = request.getParameter("hotelname");
        String indate = request.getParameter("checkindate");
        String outdate = request.getParameter("checkoutdate");
        String starlevel = request.getParameter("starlevel");
        System.out.println(hotelname+"-"+indate+"-"+outdate+"-"+starlevel);
        model.addAttribute("hotels",searchService.searchh(hotelname));
        return "index";
    }
}
