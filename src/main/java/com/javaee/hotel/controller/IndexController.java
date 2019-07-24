package com.javaee.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("welcome")
public class IndexController {
    @GetMapping(value = "")
    public String showIndex () {return "index";}
    @PostMapping(value = "")
    public String searchHotel(HttpServletRequest request, Model model){
      String hotelname = request.getParameter("hotelname");
      String indate = request.getParameter("checkindate");
      String outdate = request.getParameter("checkoutdate");
      String starlevel = request.getParameter("starlevel");
      System.out.println(hotelname+"-"+indate+"-"+outdate+"-"+starlevel);

      return "index";
    }
}
