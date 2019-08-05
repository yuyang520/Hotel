package com.javaee.hotel.controller;

import com.javaee.hotel.domain.Customer;
import com.javaee.hotel.domain.CustomerExample;
import com.javaee.hotel.domain.CustomerInfo;
import com.javaee.hotel.mapper.CustomerMapper;
import com.javaee.hotel.service.LoginService;
import com.javaee.hotel.service.MailService;
import com.javaee.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private UserService userService;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private MailService mailService;
    @GetMapping(value = {""})
    public String loginHtml(Model model, HttpServletResponse response,HttpSession session) {
        if(session.getAttribute("id")!=null) {
            return "redirect:/welcome";
        }
        model.addAttribute("tip","");
        return "/login";
    }
    @PostMapping(value = "")
    public String loginCheck(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             Model model,
                             HttpSession session) {
        if(session.getAttribute("id")!=null) {
            return "redirect:/welcome";
        }
        Customer customer = loginService.check(username,password);
        if( customer != null) {
            session.setAttribute("id",customer.getId());
            return "redirect:/welcome";
        }else {
            model.addAttribute("tip","用户名或密码错误");
            return "/login";
        }
    }
    @GetMapping(value = "/logout")
    public String logOut(HttpSession session) {
        if( session.getAttribute("id")!=null) {
            session.removeAttribute("id");
        }
        return "redirect:/welcome";
    }
    @GetMapping(value = "/findback")
    public String findBackHtml() {
        return "findback";
    }

    @PostMapping(value = "/findback")
    @ResponseBody
    public boolean sentEmail(@RequestParam("username") String username,HttpSession session) {
        CustomerExample example = new CustomerExample();
        CustomerExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        System.out.println(username);
        List<Customer> customerList = customerMapper.selectByExample(example);
        if(customerList.size()!=0) {
          String email = userService.getNowUser(customerList.get(0).getId()).get(0).getEmail();
          mailService.sendEmail(email,session);
          session.setAttribute("username",username);
          return true;
        }else {
            return false;
        }
    }
    @PostMapping(value = "/findbackCheck")
    @ResponseBody
    public String findBack(@RequestParam("checkCode") String checkCode,
                           @RequestParam("username") String username,
                           @RequestParam("password") String password,
                           HttpSession session)  {
        String checkusername = (String) session.getAttribute("username");
        if(checkusername==null) {
            return "nousername";
        }
        if(checkusername.equals(username)){
            HashMap hashMap = (HashMap) session.getAttribute("checkCode");
            if(hashMap==null) {
                return  "nocheckcode";
            }
            System.out.println(checkCode);
            if(hashMap.get("checkCode").equals(checkCode)) {
                Date date = new Date();
                long postDate = (long) hashMap.get("time");
                if ((date.getTime() - postDate) < 15 * 60 * 1000) {
                    CustomerExample example = new CustomerExample();
                    example.createCriteria().andUsernameEqualTo(username);
                    Customer customer = new Customer();
                    customer.setPassword(password);
                    customerMapper.updateByExampleSelective(customer,example);
                    session.removeAttribute("checkCode");
                    session.removeAttribute("username");
                    return "ok";
                }else{
                    return "nocheckcode";
                }
            }else{
                return "nocheckcode";
            }
        }else{
            return "nousername";
        }
    }
}
