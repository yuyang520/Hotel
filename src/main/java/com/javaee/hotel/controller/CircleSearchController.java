package com.javaee.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/circlesearch")
public class CircleSearchController {
    @GetMapping(value = {""})
    public String circlesearchHtml(HttpServletRequest request,Model model){
        model.addAttribute("hotelLatitude",request.getParameter("hotelLatitude"));
        model.addAttribute("hotelLongitude",request.getParameter("hotelLongitude"));
        return "/circlesearch";
    }

}

