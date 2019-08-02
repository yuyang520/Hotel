package com.javaee.hotel.controller;

import com.javaee.hotel.domain.Hotel;
import com.javaee.hotel.domain.Manager;
import com.javaee.hotel.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @GetMapping("")
    public String managerHtml(HttpServletRequest request,
                              HttpServletResponse response,
                              Model model) {

        Boolean isLogin = request.getSession().getAttribute("username") !=null ;
//        System.out.println(isLogin?);
        model.addAttribute("isLogin",isLogin);
        return "/manager";
    }

    @GetMapping(value = "/managerList.json",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Manager> getManagerJSON(){
        return managerService.managerRespond();
    }

    @GetMapping("/add")
    public String goAddManager(Model model){
        model.addAttribute("manager",new Manager());
        return "manager-add";
    }

    @PostMapping("/add")
    public String saveManager(Manager manager){
        managerService.saveManager(manager);
        return "redirect:/manager";
    }

    @GetMapping("/edit")
    public String goManagerEditPage(@RequestParam("username") String username,Model model){
        Manager manager = managerService.findManagerByPrimaryKey(username);
        model.addAttribute("manager",manager);
        return "manager-edit";
    }

    @GetMapping("/ManagerLogin")
    @ResponseBody
    public Boolean login(@RequestParam("username") String username,
                         @RequestParam("password") String password,
                         HttpServletRequest request){
        request.getSession().setAttribute("username","username");
        return true;
    }


    @PostMapping("/deleteManager")
    @ResponseBody
    public Boolean deleteManager(@RequestParam("username") String username){
        managerService.deleteManager(username);
        return true;
    }
}
