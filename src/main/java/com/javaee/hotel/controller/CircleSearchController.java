package com.javaee.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/circlesearch")
public class CircleSearchController {
    @GetMapping(value = {""})
    public String circlesearchHtml(){
        return "/circlesearch";
    }

}

