package com.javaee.hotel.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSON;
import com.javaee.hotel.domain.Order;
import com.javaee.hotel.service.MOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/MOrderlist")
public class MOrderController {
    @Autowired
    private MOrderService mOrderService;

    @GetMapping("")
    public String MOrderHtml(){
        return "/MOrderlist";
    }
    @GetMapping(value = "/orderlist.json",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Order> getOrderListJson() {
        System.out.println(mOrderService.orderlistRespond());
        return mOrderService.orderlistRespond();
    }

}
