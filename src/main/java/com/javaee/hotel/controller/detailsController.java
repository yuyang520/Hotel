package com.javaee.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/welcome/details")
public class detailsController {
    @GetMapping(value="")
    public String showIndex () {return "details";}
}
