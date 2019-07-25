package com.javaee.hotel.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/searchmap")
public class SearchmapController {
    @GetMapping(value = {""})
    public String searchHtml(){
        return "/searchmap";
    }
}
