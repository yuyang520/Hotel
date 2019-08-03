package com.javaee.hotel.controller;

import com.javaee.hotel.domain.CustomerInfo;
import com.javaee.hotel.domain.CustomerInfoExample;
import com.javaee.hotel.mapper.CustomerInfoMapper;
import com.javaee.hotel.service.UserService;
import com.javaee.hotel.tool.PictureTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/userinfo")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private CustomerInfoMapper customerInfoMapper;
    @Autowired
    private PictureTool pictureTool;

    @GetMapping
    public String goUserPage(Model model, HttpSession session){
        if(session.getAttribute("id")==null) {
            return "redirect:/welcome";
        }
        int id = Integer.parseInt(session.getAttribute("id").toString());
        model.addAttribute("userInfo",userService.getNowUser(id));
        return "userPage";
    }

    @PostMapping
    public String returnPage(Model model, HttpSession session, HttpServletRequest request){
        String icon = request.getParameter("icon");
        String nickName = request.getParameter("nickName");
        String realName = request.getParameter("realName");
        String personId = request.getParameter("personId");
        int id = Integer.parseInt(session.getAttribute("id").toString());
        CustomerInfo customerInfo = userService.getNowUser(id).get(0);
        if(icon!=""&&icon!=null){
            customerInfo.setIcon(pictureTool.getFilePath(icon));
        }
        if(nickName!=""&&nickName!=null){
            customerInfo.setNickName(nickName);
        }
        if(realName!=""&&realName!=null){
            customerInfo.setName(realName);
        }
        if(personId!=""&&personId!=null) {
            customerInfo.setPersonId(personId);
        }
        CustomerInfoExample example = new CustomerInfoExample();
        example.createCriteria().andIdEqualTo(id);
        customerInfoMapper.updateByExample(customerInfo,example);
        model.addAttribute("userInfo",userService.getNowUser(id));
        return "userPage";
    }
}
