package com.javaee.hotel.controller;

import com.javaee.hotel.domain.Hotel;
import com.javaee.hotel.service.RoomService;
import com.javaee.hotel.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
        String minPriceString = request.getParameter("minPrice");
        String city = request.getParameter("city");
        Integer starlevel = Integer.parseInt(request.getParameter("starlevel"));
        float minPriceFloat=0;
        if(minPriceString!=""){
            minPriceFloat = Float.parseFloat(minPriceString);
        }
        System.out.println(hotelname+"-"+minPriceFloat+"-"+city+"-"+starlevel);
        List<Hotel> hotelList=searchService.searchh(hotelname,minPriceFloat,city,starlevel);
        if(hotelList.isEmpty()){
            model.addAttribute("notFoundMessage","未查找到结果");
        }
        model.addAttribute("hotels",hotelList);
        return "index";
    }
}
