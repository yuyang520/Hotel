package com.javaee.hotel.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

@Controller
public class MailControlleryy{

    @Autowired
    private JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String from;
    @GetMapping("/setemail")
    public String sendmail(){
        return "setemail";
    }

    @PostMapping("/setemail")
    @ResponseBody
    public String sendSimpleMail(HttpServletRequest request, Model model) throws Exception {
        System.out.println("邮件在此1");
        SimpleMailMessage message = new SimpleMailMessage();
        String email = request.getParameter("email");
        System.out.println("邮件在此");
        String checkCode = String.valueOf(new Random().nextInt(899999) + 100000);
        String messagas = "【1105】欢迎注册最牛逼酒店订购,您的邮箱验证码是"
                +checkCode+",请在10分钟内完成注册\n";
        message.setFrom(from);
        System.out.println("邮箱" + email+"验证码"+checkCode);

        message.setTo(email);
        message.setSubject("主题：验证邮件");
        message.setText(messagas);
        System.out.println("邮件在此");
        mailSender.send(message);
        System.out.println("邮件在此");
        return checkCode;
    }

}