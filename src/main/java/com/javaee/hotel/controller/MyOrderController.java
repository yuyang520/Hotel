package com.javaee.hotel.controller;

import com.javaee.hotel.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

@Controller

public class MyOrderController {
    @Autowired
    private OrderService orderService;
    @RequestMapping("myorder")
    public String searchOrder(HttpServletRequest request,Model model) {
        String orderHotelName = request.getParameter("orderHotelName");
        String checkInTime = request.getParameter("checkInTime");
        String checkOutTime = request.getParameter("checkOutTime");
        String orderStatusStr = request.getParameter("orderStatus");
        int orderStatus=0;
        if(orderStatusStr != null){
            orderStatus = Integer.parseInt(orderStatusStr);
        }

        model.addAttribute("orderListInfos",orderService.searchOrderListInfo(orderHotelName,checkInTime,checkOutTime,orderStatus));

        return "myorder";
    }
}
