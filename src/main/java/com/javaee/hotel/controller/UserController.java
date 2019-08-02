package com.javaee.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/userinfo")
public class UserController {

    @GetMapping
    public String goUserPage(){
        return "userPage";
    }
}
