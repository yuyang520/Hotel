package com.javaee.hotel.tool;

import com.javaee.hotel.domain.Hotel;
import com.javaee.hotel.mapper.HotelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
@Controller
@RequestMapping("/upload")
public class PictureTool {
    @Autowired
    private HotelMapper hotelMapper;
    @GetMapping(value = "")
    public String goPage () {
        return "uptest";
    }
    @PostMapping(value = "")
    public String upload (HttpServletRequest request, Model model) {
        String hotelId = request.getParameter("hotelIDP");
        String path = request.getParameter("file");
        if(!path.isEmpty()){
            model.addAttribute( "path",getFilePath(path));
            System.out.println(path);
            Hotel hotel = hotelMapper.selectByPrimaryKey(hotelId);
            System.out.println(hotel.getHotelCheckinTime());
            hotel.setPicture(getFilePath(path));
            hotelMapper.updateByPrimaryKey(hotel);
        }
        return "uptest";
    }
    public String getFilePath(String filePath){
        String temp[] = filePath.replaceAll("\\\\","/").split("/");
        String fileName = "";
        if(temp.length > 1){
            fileName = temp[temp.length - 1];
        }
        return "/Path/"+fileName;
    }
}
