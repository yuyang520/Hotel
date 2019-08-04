package com.javaee.hotel.controller;

import com.javaee.hotel.domain.CustomerInfo;
import com.javaee.hotel.service.MailService;
import com.javaee.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

@Controller
@RequestMapping("/safecenter")
public class SafeController {
    @Autowired
    private UserService userService;
    @Autowired
    private MailService mailService;

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
    @PostMapping(value = "/setemail")
    public void enterEmail(@RequestParam("email") String email,HttpSession session){
        String checkCode = String.valueOf(new Random().nextInt(899999) + 100000);
        String message = "您的注册验证码为："+checkCode;
        System.out.println("???????");
        System.out.println(message);
        try {
            mailService.sendSimpleMail(email, "注册验证码", message);
            HashMap hashMap = new HashMap();
            Date date = new Date();
            hashMap.put("time",date.getTime());
            hashMap.put("checkCode",checkCode);
            session.setAttribute("checkCode",hashMap);
        }catch (Exception e){

        }
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
    @PostMapping("/check")
    @ResponseBody
    public String checkCode(@RequestParam("checkCode") String checkCode,HttpSession session) {
        HashMap hashMap = (HashMap) session.getAttribute("checkCode");
        System.out.println((String)hashMap.get("checkCode"));
        System.out.println("dffdf");
        if(checkCode.equals(hashMap.get("checkCode"))) {
            Date date = new Date();
            long postDate =(long)hashMap.get("time");
            if((date.getTime() - postDate)<15*60*1000) {
                return "ok";
            }
        }
        return "no";
    }
}
