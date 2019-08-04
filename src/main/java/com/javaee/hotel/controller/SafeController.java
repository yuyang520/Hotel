package com.javaee.hotel.controller;

import com.javaee.hotel.domain.CustomerInfo;
import com.javaee.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/safecenter")
public class SafeController {
    @Autowired
    private UserService userService;

    @GetMapping(value="")
    public String goSafePage(HttpSession session, Model model){
        if(session.getAttribute("id")==null) {
            return "redirect:/welcome";
        }
        int id = Integer.parseInt(session.getAttribute("id").toString());
        CustomerInfo customerInfo = userService.getNowUser(id).get(0);
        String tel = customerInfo.getTelephone();
        if(tel!=null&&tel!=""){
            customerInfo.setTelephone(hidetel(tel));
        }
        model.addAttribute("userInfo",customerInfo);
        return "safecenter";
    }

    public String hidetel(String tel){
        char[] chartel = tel.toCharArray();
        chartel[4] = '*';
        chartel[5] = '*';
        chartel[6] = '*';
        return chartel.toString();
    }
}
