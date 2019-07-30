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

    @GetMapping(value = {""})
    public String showIndex (HttpServletRequest request, Model model) {
        String hotelname = request.getParameter("hotelname");
        return "searchmap";
    }

    @PostMapping(value = "/map.json",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Hotel> searchHotel(HttpServletRequest request, Model model){

        String hotelname = request.getParameter("hotelname");
        List<Hotel> hotelList=mapseachService.search(hotelname);
        if(hotelList.isEmpty()){
            model.addAttribute("notFoundMessage","未查找到结果");
        }
        model.addAttribute("hotels", hotelList);

        return mapseachService.search(hotelname);
    }
}
