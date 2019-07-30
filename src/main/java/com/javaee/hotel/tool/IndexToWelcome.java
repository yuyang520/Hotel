package com.javaee.hotel.tool;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexToWelcome {
    @RequestMapping("")
    public String toWelcome(){
        return "redirect:/welcome";
    }
}
