package com.javaee.hotel.controller;
import com.javaee.hotel.domain.Customer;
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
        int checkPassword = registerService.checkStr(password,8,16);
        int checkUsernameConflict = registerService.checkStr(username,1,30);
        if ( checkPassword == 0 && checkUsernameConflict == 0 && !checkUsername) {
            Customer customer = new Customer();
            customer.setPassword(password);
            customer.setUsername(username);
            registerService.register(customer);
            return "/index";
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

