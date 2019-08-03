package com.javaee.hotel.controller;

import com.javaee.hotel.domain.Hotel;
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
@RequestMapping("/bigmap")
public class BigMapController {
    @Autowired
    private SearchService searchService;

    @GetMapping(value = "")
    public String bigmapHtml() {
        return "bigmap";
    }
    @PostMapping(value = "")
    public String getallhotel(HttpServletRequest request, Model model){
        String hotelname = request.getParameter("hotelname");
        String city = request.getParameter("city");
        Integer minPrice = Integer.parseInt(request.getParameter("minPrice"));
        Integer starlevel = Integer.parseInt(request.getParameter("starlevel"));
        List<Hotel> hotelList=searchService.searchh(hotelname,minPrice,city,starlevel);
        model.addAttribute("hotels",hotelList);
        System.out.println("gethere");
        return "/bigmap";
    }
}
