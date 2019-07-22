package com.javaee.hotel.controller;
import com.javaee.hotel.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    RegisterService registerService;
    @GetMapping(value = {""})
    public String registerHtml() {
        return "register";
    }
    @PostMapping(value = {""})
    public String register(HttpServletRequest request, Model model) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean checkUsername = registerService.checkUsername(username);
        int checkPassword = registerService.checkPassword(password);
        //检验用户名是否合格
        if( checkUsername ) {
            model.addAttribute("tip","用户名已存在");
            return "/register";
        }
        if ( checkPassword == 0 ) {
            return "/index";
        }
        else if( checkPassword == 1 || checkPassword == 2) {
            model.addAttribute("tip","密码格式错误（仅为字母数字和一些常用字符）");
            return "/register";
        }else if (checkPassword == 3) {
            model.addAttribute("tip","密码应不大于16个字符");
            return "/register";
        }else if (checkPassword == 4) {
            model.addAttribute("tip","密码应不小于8个字符");
        }
        return "/index";
    }
    @PostMapping(value = {"/checkUsername"})
    @ResponseBody
    public String checkUsername(HttpServletRequest request) {
        String username = request.getParameter("username");
        System.out.println(username);
        if( registerService.checkUsername(username))
            return "用户名已存在";
        else
            return "";

    }
}

