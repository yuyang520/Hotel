package com.javaee.hotel.controller;


import com.javaee.hotel.domain.Hotel;
import com.javaee.hotel.domain.OrderList;
import com.javaee.hotel.service.HotelListService;
import com.javaee.hotel.service.MOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hotelList")
public class HotelListController {
    @Autowired
    private HotelListService hotelListService;

    @GetMapping("")
    public String hotelHtml(){

        return "/hotelList";
    }

    @GetMapping(value = "/hotel.json",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Hotel> getOrderListJson() {
        //System.out.println(hotelListService.hotelListRespond());
//        System.out.println(hotelListService.hotelListRespond());
        return hotelListService.hotelListRespond();
    }

    @GetMapping("/add")
    public String goHotelPage(Model model){
        model.addAttribute("Hotel",new Hotel());
        return "hotel-add";
    }

    @PostMapping("/add")
    public String saveHotel(Hotel hotel){
        hotelListService.saveHotel(hotel);

        return "redirect:/hotelList";
    }

    @GetMapping("/edit")
    public String goorderEditPage(@RequestParam("hotelId") String hotelId, Model model){
        Hotel hotel = hotelListService.findHotelByPrimaryKey(hotelId);
        System.out.println(hotelId);
        model.addAttribute("hotel",hotel);
        return "hotel-edit";
    }


    @PostMapping("/delete")
    @ResponseBody
    public boolean delete(@RequestParam("hotelId") String hotelId){
        hotelListService.deleteHotelById(hotelId);
        return true;
    }

}