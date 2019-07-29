package com.javaee.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("myorder")
public class MyOrderController {
    @GetMapping(value = "")
    public String showMyOrder(){
        return "myorder";
    }
}
