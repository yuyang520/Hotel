package com.javaee.hotel.controller;


import com.javaee.hotel.domain.Customer;
import com.javaee.hotel.domain.CustomerInfo;
import com.javaee.hotel.service.CustomerListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customerList")
public class CustomerListController {
    @Autowired
    private CustomerListService customerListService;

    @GetMapping("")
    public String customerListHtml(){
        return "/customerList";
    }

    @GetMapping(value = "/customerList.json", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<CustomerInfo> getCustomerInfoJson(){

        return customerListService.customerInfoRespond();
    }

    @GetMapping("/add")
    public String goCustomerAddPage(){
        return "customer-add";
    }

    @PostMapping("/add")
    public String saveCustomerList(CustomerInfo customerInfo){
        customerListService.saveCustomerList(customerInfo);

        return "redirect:/customerList";
    }

//    @GetMapping("/edit")
//    public String goCustomerListEdit(@RequestParam("id") int id , Model model){
//        Customer cus = customerListService.findCustomerInfoByPrimaryKey(id);
//        model.addAttribute("customer",cus);
//
//        return "customer-add";
//    }

    @GetMapping("/edit")
    public String test(@RequestParam("id") int id , Model model) {
        CustomerInfo customerInfo = customerListService.getCustomerInfo(id);
        if(customerInfo != null){
            model.addAttribute("customerInfo",customerInfo);
            return "customer-add";
        }
        else{
            return null;
        }

    }
}
