//package com.javaee.hotel.mail;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//
//@Controller
//public class SendByEmailController {
//    @Autowired
//    @Qualifier("serdbyemail")
//    private SendByEmailTools service;
//
//    @PostMapping("/mailtest")
//    public String send(HttpServletRequest request, Model model){
//
//        String email = request.getParameter("email");
//        String password = request.getParameter("password");
//
//        String sender = "2240369235@qq.com";   //这个是发送人的邮箱
//        String receiver = email;  //这个是接受人的邮箱
//        String title="约翰福音";    //标题
//        String text="【约3:16】“　神爱世人，甚至将他的独生子赐给他们，叫一切信他的，不至灭亡，反得永生。";
//
//        String result=service.send(sender, receiver, title, text);
//        return result;
//    }
//
//}
