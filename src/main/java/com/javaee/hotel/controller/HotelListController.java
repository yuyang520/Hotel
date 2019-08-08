package com.javaee.hotel.controller;
import com.javaee.hotel.domain.Hotel;
import com.javaee.hotel.domain.OrderList;
import com.javaee.hotel.mapper.HotelMapper;
import com.javaee.hotel.service.HotelListService;
import com.javaee.hotel.service.MOrderService;
import com.javaee.hotel.tool.PictureTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
@Controller
@RequestMapping("/hotelList")
public class HotelListController {
    @Autowired
    private HotelListService hotelListService;
    @Autowired
    private HotelMapper hotelMapper;

    @GetMapping("")
    public String hotelHtml(HttpServletRequest request,
                            HttpServletResponse response,
                            Model model){
        Boolean isLogin = request.getSession().getAttribute("username") !=null ;
        model.addAttribute("isLogin",isLogin);
        return "/hotelList";
    }

    @GetMapping(value = "/hotel.json",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Hotel> getOrderListJson() {
        return hotelListService.hotelListRespond();
    }

    @GetMapping("/add")
    public String goHotelPage(Model model){
        model.addAttribute("Hotel",new Hotel());
        return "hotel-add";
    }

    @PostMapping("/add")
    public String saveHotel(@RequestParam("icon") MultipartFile file,Hotel hotel,HttpServletRequest request){
        if(file!=null&&!file.getOriginalFilename().isEmpty()){
            String fileName = file.getOriginalFilename();
            String filePath = "C:\\Users\\Dell\\Desktop\\imageStore\\";
            Date date = new Date();
            fileName = date.getTime()+fileName;
            File dest = new File(filePath + fileName);
            hotel.setPicture("/upload/"+fileName);
            try {
                file.transferTo(dest);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }else{
            hotel.setPicture(null);
        }
//        String path = request.getParameter("picture");
//        PictureTool pictureTool = new PictureTool();
//        hotel.setPicture(pictureTool.getFilePath(path));

        hotelListService.saveHotel(hotel);
        return "redirect:/hotelList";
    }

    @GetMapping("/edit")
    public String goorderEditPage(@RequestParam("hotelId") String hotelId, Model model){
        Hotel hotel = hotelListService.findHotelByPrimaryKey(hotelId);
        model.addAttribute("hotel",hotel);
        return "hotel-edit";
    }

    @PostMapping("/delete")
    @ResponseBody
    public boolean delete(@RequestParam("hotelId") String hotelId){
        hotelListService.deleteHotelById(hotelId);
        return true;
    }

    @PostMapping("/exit")
    @ResponseBody
    public Boolean LogOut(HttpServletResponse response,
                          HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return true;
    }
}