package com.javaee.hotel.controller;

import com.javaee.hotel.domain.Hotel;
import com.javaee.hotel.domain.OrderList;
import com.javaee.hotel.domain.Room;
import com.javaee.hotel.mapper.IconMapper;
import com.javaee.hotel.service.RoomService;
import com.javaee.hotel.tool.PictureTool;
import com.javaee.hotel.tool.RoomItemStaticData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
public class RoomController {
    @Autowired
    private RoomService roomService;
    @GetMapping("/roomManage")
    public String roomManageHtml(Model model) {
        model.addAttribute("hotelidList",roomService.getHotelList());
        model.addAttribute("roomList",roomService.getRoomList(null));
        return "/roomManage";
    }
    @PostMapping("/roomManage")
    public String roomManageInsert(Model model, Room room) {
        roomService.addRoom(room);
        System.out.println(room.getChineseName());
        model.addAttribute("hotelidList",roomService.getHotelList());
        model.addAttribute("roomList",roomService.getRoomList(null));
        return "/roomManage";
    }
    @GetMapping("/roomList")
    public String MOrderHtml(HttpServletRequest request,
                             HttpServletResponse response,
                             Model model){
        Boolean isLogin = request.getSession().getAttribute("username") !=null ;
        model.addAttribute("isLogin",isLogin);
        return "/roomList";
    }
    @GetMapping(value = "/roomList/roomList.json",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Room> getRoomJson() {
        return roomService.roomRespond();
    }
    @GetMapping("/roomList/add")
    public String goRoomPage(Model model){
        model.addAttribute("room",new Room());
        RoomItemStaticData roomItemStaticData = new RoomItemStaticData();
        model.addAttribute("iconList",roomItemStaticData.getDatabaseRoomItemContent());
        return "room-add";
    }

    @PostMapping("/roomList/add")
    public String saveRoom(@RequestParam("photo") MultipartFile file , Room room, HttpServletRequest request){

        if(file!=null){
            String fileName = file.getOriginalFilename();
            String filePath = "C:\\Users\\Dell\\Desktop\\imageStore\\";
            Date date = new Date();
            fileName=date.getTime()+fileName;
            File dest = new File(filePath +fileName);
            room.setPhoto("/upload"+fileName);
//            customerInfo.setIcon("/upload/"+fileName);
            try {
                file.transferTo(dest);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

//        String path = request.getParameter("photo");
//        if(path!=null) {
//            PictureTool pictureTool = new PictureTool();
//            room.setPhoto(pictureTool.getFilePath(path));
//        }


        roomService.saveRoom(room);
        return "redirect:/roomList";
    }

    @GetMapping("/roomList/edit")
    public String goRoomEditPage(@RequestParam("roomId") String roomId, Model model){
        Room room = roomService.findRoomByPrimaryKey(roomId);
        RoomItemStaticData roomItemStaticData = new RoomItemStaticData();
        model.addAttribute("iconList",roomItemStaticData.getDatabaseRoomItemContent());
        model.addAttribute("room",room);
        return "room-edit";
    }


    @PostMapping("/roomList/deleteRoom")
    @ResponseBody
    public boolean deleteRoom(@RequestParam("roomId") String roomId){
        roomService.deleteRoomById(roomId);
        return true;
    }

    @PostMapping("/roomList/exit")
    @ResponseBody
    public Boolean LogOut(HttpServletResponse response,
                          HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return true;
    }
}
