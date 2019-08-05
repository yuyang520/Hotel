package com.javaee.hotel.controller;

import com.javaee.hotel.domain.Customer;
import com.javaee.hotel.domain.CustomerInfo;
import com.javaee.hotel.domain.CustomerInfoExample;
import com.javaee.hotel.mapper.CustomerInfoMapper;
import com.javaee.hotel.service.MailService;
import com.javaee.hotel.service.RegisterService;
import com.javaee.hotel.service.UserService;
import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    @Autowired
    private RegisterService registerService;
    @Autowired
    private CustomerInfoMapper customerInfoMapper;

    @GetMapping(value="")
    public String goSafePage(HttpSession session, Model model){
        int id=userService.getUserId(session);
        if(id<0) {
            return "redirect:/welcome";
        }
        CustomerInfo customerInfo = userService.getNowUser(id).get(0);
        String tel = customerInfo.getTelephone();
        if(tel!=null&&tel!=""){
            customerInfo.setTelephone(hidetel(tel));
        }
        model.addAttribute("userInfo",customerInfo);
        return "safecenter";
    }

    @GetMapping(value = "/modifypwd")
    public String gomPwdPage(HttpSession session,Model model){
        int id=userService.getUserId(session);
        if(id<0) {
            return "redirect:/welcome";
        }
        model.addAttribute("callback",false);
        return "changepwd";
    }
    @PostMapping(value = "/modifypwd")
    public String changepwd(HttpServletRequest request,HttpSession session,Model model) {
        String oldpwd = request.getParameter("oldpwd");
        String newpwd = request.getParameter("newpwd");
        int id = userService.getUserId(session);
        if(id<0) {
            return "/welcome";
        }
        if(oldpwd.equals(newpwd)) {
            model.addAttribute("callback",true);
            return "changepwd";
        }
        if(userService.checkUser(id,oldpwd)){
            if(registerService.checkStr(newpwd,8,16)==0){
                userService.updatePwd(id,newpwd);
                session.removeAttribute("id");
                return "/login";
            }
            else {
                model.addAttribute("callback",true);
                return "changepwd";
            }

        }else {
            model.addAttribute("callback",true);
            return "changepwd";
        }
    }

    @GetMapping(value = "/modifytel")
    public String gomTelPage(HttpSession session){
        int id=userService.getUserId(session);
        if(id<0) {
            return "redirect:/welcome";
        }
        return "changetel";
    }

    @GetMapping(value = "/modifyemail")
    public String gomEmailPage(HttpSession session){
        int id=userService.getUserId(session);
        if(id<0) {
            return "redirect:/welcome";
        }
        return "changeemail";
    }

    @GetMapping(value = "/settel")
    public String gosTelPage(HttpSession session){
        int id=userService.getUserId(session);
        if(id<0) {
            return "redirect:/welcome";
        }
        return "settel";
    }

    @GetMapping(value = "/setemail")
    public String gosEmailPage(HttpSession session){
        int id=userService.getUserId(session);
        if(id<0) {
            return "redirect:/welcome";
        }
        return "setemail";
    }
    @PostMapping(value = "/setemail")
    public String enterEmail(@RequestParam("email") String email,HttpSession session){
        String checkCode = String.valueOf(new Random().nextInt(899999) + 100000);
        String message = "您的注册验证码为："+checkCode;
        try {
            mailService.sendSimpleMail(email, "注册验证码", message);
            HashMap hashMap = new HashMap();
            Date date = new Date();
            hashMap.put("time",date.getTime());
            hashMap.put("checkCode",checkCode);
            session.setAttribute("checkCode",hashMap);
        }catch (Exception e){
            e.toString();
        }
        return "setemail";
    }
    @GetMapping(value = "/unsettel")
    public String gouTelPage(HttpSession session,Model model){
        int id=userService.getUserId(session);
        if(id<0) {
            return "redirect:/welcome";
        }
        CustomerInfo customerInfo = userService.getNowUser(id).get(0);
        model.addAttribute("userInfo",customerInfo);
        return "unsettel";
    }

    @GetMapping(value = "/unsetemail")
    public String gouEmailPage(HttpSession session,Model model){
        int id=userService.getUserId(session);
        if(id<0) {
            return "redirect:/welcome";
        }
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
    public String checkCode(@RequestParam("checkCode") String checkCode,@RequestParam("email") String email, HttpSession session) {
        HashMap hashMap = (HashMap) session.getAttribute("checkCode");
        if(checkCode.equals(hashMap.get("checkCode"))) {
            Date date = new Date();
            long postDate =(long)hashMap.get("time");
            if((date.getTime() - postDate)<15*60*1000) {
                int id=userService.getUserId(session);
                CustomerInfo now = userService.getNowUser(id).get(0);
                now.setEmail(email);
                userService.updateByPK(now,id);
                return "ok";
            }
        }
        return "no";
    }
}
