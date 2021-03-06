package com.javaee.hotel.controller;

import com.javaee.hotel.domain.Hotel;
import com.javaee.hotel.service.RoomService;
import com.javaee.hotel.service.SearchService;
import com.javaee.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("welcome")
public class IndexController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private SearchService searchService;
    @Autowired
    private UserService userService;

    @GetMapping(value = "")
    public String showIndex (Model model, HttpSession session) {
        model.addAttribute("hotels", roomService.getHotelList());
        int id = 0;
        if(session.getAttribute("id")!=null){
            id = Integer.parseInt(session.getAttribute("id").toString());
        }
        String bigmapUrl = "/bigmap?hotelname=&&city=&&minPrice=7&&starlevel=6";
        model.addAttribute("userInfo",userService.getNowUser(id));
        model.addAttribute("bigmapUrl",bigmapUrl);
        return "index";
    }
    @PostMapping(value = "")
    public String searchHotel(HttpServletRequest request, Model model,HttpSession session){
        String hotelname = request.getParameter("hotelname");
        String city = request.getParameter("city");
        Integer minPrice = Integer.parseInt(request.getParameter("minPrice"));
        Integer starlevel = Integer.parseInt(request.getParameter("starlevel"));
        int id = 0;
        if(session.getAttribute("id")!=null){
            id = Integer.parseInt(session.getAttribute("id").toString());
        }
        String bigmapUrl = "/bigmap?hotelname="+hotelname+"&&city="+city+"&&minPrice="+minPrice+"&&starlevel="+starlevel;
        model.addAttribute("userInfo",userService.getNowUser(id));
        List<Hotel> hotelList=searchService.searchh(hotelname,minPrice,city,starlevel);
        model.addAttribute("hotels",hotelList);
        model.addAttribute("bigmapUrl",bigmapUrl);
        return "index";
    }
}
