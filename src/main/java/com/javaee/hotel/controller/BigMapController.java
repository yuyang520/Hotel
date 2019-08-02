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
//    @PostMapping(value = "")
//    public String getallhotel(HttpServletRequest request, Model model){
//        List<Hotel> hotelList=searchService.searchh();
//        model.addAttribute("hotels",hotelList);
//        return "bigmap";
//    }
//
}
