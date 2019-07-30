package com.javaee.hotel.controller;

import com.javaee.hotel.domain.Customer;
import com.javaee.hotel.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginService loginService;
    @GetMapping(value = {""})
    public String loginHtml(Model model, HttpServletResponse response) {
        model.addAttribute("tip","");
        return "/login";
    }
    @PostMapping(value = "")
    public String loginCheck(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             Model model,
                             HttpSession session) {
        Customer customer = loginService.check(username,password);
        if( customer != null) {
            session.setAttribute("id",customer.getId());
            return "redirect:/welcome";
        }else {
            model.addAttribute("tip","用户名或密码错误");
            return "/login";
        }
    }
}
