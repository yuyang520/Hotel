package com.javaee.hotel.controller;

import com.javaee.hotel.domain.Manager;
import com.javaee.hotel.service.ManagerLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@Controller
@RequestMapping("/ManagerLogin")
public class ManagerLoginController {
    @Autowired
    ManagerLoginService managerLoginService;
    @GetMapping("")
    public String managerLoginPage(){
        return "ManagerLogin";
    }
    @PostMapping("")
    public String loginCheck(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model,
                        HttpSession session) {
        Manager manager = managerLoginService.check(username, password);
        if (manager != null) {
            session.setAttribute("username", manager.getUsername());
            return "redirect:/MOrderlist";
        } else {
            model.addAttribute("tip", "用户名或密码错误");
            return "/ManagerLogin";
        }
    }
}

