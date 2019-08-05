package com.javaee.hotel.service;

import com.sun.xml.messaging.saaj.packaging.mime.internet.MimeUtility;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@Service("mailService")
public class MailService {
    @Value("${spring.mail.username}")
    private String from;
    @Autowired
    private JavaMailSender mailSender;
    Logger logger = LoggerFactory.getLogger(this.getClass());
    public void sendSimpleMail(String to,String title,String content){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(title);
        message.setText(content);
        mailSender.send(message);
    }
    public void sendAttachmentsMail(String to, String title, String cotent, List<File> fileList){
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(title);
            helper.setText(cotent);
            String fileName = null;
            for (File file:fileList) {
                fileName = MimeUtility.encodeText(file.getName(), "GB2312", "B");
                helper.addAttachment(fileName, file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        mailSender.send(message);
    }
    public void sendEmail(String email, HttpSession session){
        String checkCode = String.valueOf(new Random().nextInt(899999) + 100000);
        String message = "您的注册验证码为："+checkCode;
        try {
            sendSimpleMail(email, "注册验证码", message);
            HashMap hashMap = new HashMap();
            Date date = new Date();
            hashMap.put("time",date.getTime());
            hashMap.put("checkCode",checkCode);
            session.setAttribute("checkCode",hashMap);
        }catch (Exception e){
            e.toString();
        }

    }
}
