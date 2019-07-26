package com.javaee.hotel.controller;


import com.javaee.hotel.domain.CustomerInfo;
import com.javaee.hotel.service.CustomerListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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


}
