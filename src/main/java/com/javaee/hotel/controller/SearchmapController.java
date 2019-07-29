package com.javaee.hotel.controller;

import com.javaee.hotel.domain.Hotel;
import com.javaee.hotel.service.MapseachService;
import com.javaee.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/searchmap")
public class SearchmapController {
    @Autowired
    private MapseachService mapseachService;
    @Autowired
    private RoomService roomService;
    @GetMapping(value = {""})
    public String showIndex (Model model) {
        model.addAttribute("hotels", roomService.getHotelList());
        return "searchmap";
    }

    @PostMapping(value = "/map.json",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Hotel> searchHotel(HttpServletRequest request){
        String hotelname = request.getParameter("hotelname");
        String indate = request.getParameter("checkindate");
        String outdate = request.getParameter("checkoutdate");
        String starlevel = request.getParameter("starlevel");
        //System.out.println(hotelname+"-"+indate+"-"+outdate+"-"+starlevel);
        //model.addAttribute("hotels",mapseachService.search(hotelname));
//        List<Hotel>  list = mapseachService.search(hotelname);
//        System.out.println();
        return mapseachService.search(hotelname);
    }
}
