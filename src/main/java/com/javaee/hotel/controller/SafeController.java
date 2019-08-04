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

    @GetMapping(value = "/modifypwd")
    public String gomPwdPage(HttpSession session){
        if(session.getAttribute("id")==null) {
            return "redirect:/welcome";
        }
        return "changepwd";
    }

    @GetMapping(value = "/modifytel")
    public String gomTelPage(HttpSession session){
        if(session.getAttribute("id")==null) {
            return "redirect:/welcome";
        }
        return "changetel";
    }

    @GetMapping(value = "/modifyemail")
    public String gomEmailPage(HttpSession session){
        if(session.getAttribute("id")==null) {
            return "redirect:/welcome";
        }
        return "changeemail";
    }

    @GetMapping(value = "/settel")
    public String gosTelPage(HttpSession session){
        if(session.getAttribute("id")==null) {
            return "redirect:/welcome";
        }
        return "settel";
    }

    @GetMapping(value = "/setemail")
    public String gosEmailPage(HttpSession session){
        if(session.getAttribute("id")==null) {
            return "redirect:/welcome";
        }
        return "setemail";
    }

    @GetMapping(value = "/unsettel")
    public String gouTelPage(HttpSession session,Model model){
        if(session.getAttribute("id")==null) {
            return "redirect:/welcome";
        }
        int id = Integer.parseInt(session.getAttribute("id").toString());
        CustomerInfo customerInfo = userService.getNowUser(id).get(0);
        model.addAttribute("userInfo",customerInfo);
        return "unsettel";
    }

    @GetMapping(value = "/unsetemail")
    public String gouEmailPage(HttpSession session,Model model){
        if(session.getAttribute("id")==null) {
            return "redirect:/welcome";
        }
        int id = Integer.parseInt(session.getAttribute("id").toString());
        CustomerInfo customerInfo = userService.getNowUser(id).get(0);
        model.addAttribute("userInfo",customerInfo);
        return "unsetemail";
    }

    public String hidetel(String tel){
        char[] chartel = tel.toCharArray();
        chartel[3] = '*';
        chartel[4] = '*';
        chartel[5] = '*';
        chartel[6] = '*';
        return new String(chartel);
    }
}
