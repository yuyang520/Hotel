package com.javaee.hotel.controller;

import com.javaee.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/userinfo")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String goUserPage(Model model, HttpSession session){
        if(session.getAttribute("id")==null) {
            return "redirect:/welcome";
        }
        int id = Integer.parseInt(session.getAttribute("id").toString());
        model.addAttribute("userInfo",userService.getNowUser(id));
        return "userPage";
    }
}
