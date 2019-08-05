//package com.javaee.hotel.mail;
//
//
//import com.javaee.hotel.mail.MailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.Random;
//
//@Controller
//@RequestMapping("mailtest")
//public class MailController {
//    @Autowired
//    private MailService mailService;
//
//    @RequestMapping(value = {""})
//    public String getCheckCode(String email){
//        System.out.println("start");
//        String checkCode = String.valueOf(new Random().nextInt(899999) + 100000);
//        String message = "您的注册验证码为："+checkCode;
//
//        mailService.sendSimpleMail(email, "注册验证码", message);
//        System.out.println("END");
//        System.out.println(checkCode);
//        return "/mailtest";
//    }
//}
