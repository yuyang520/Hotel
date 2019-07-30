package com.javaee.hotel.controller;

import com.javaee.hotel.domain.OrderList;
import com.javaee.hotel.mapper.OrderListMapper;
import com.javaee.hotel.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("myorder")
public class MyOrderController {
    @Autowired
    private OrderListMapper orderListMapper;
    @Autowired
    private OrderService orderService;
    @GetMapping(value = "")
    @PostMapping(value = "")
    public String searchOrder(HttpServletRequest request, Model model, HttpSession session) {
        if(session.getAttribute("id")==null) {
            return "redirect:/welcome";
        }
        int userId = Integer.parseInt(session.getAttribute("id").toString());
        String orderHotelName = request.getParameter("orderHotelName");
        String checkInTime = request.getParameter("checkInTime");
        String checkOutTime = request.getParameter("checkOutTime");
        String orderStatusStr = request.getParameter("orderStatus");
        int orderStatus=0;
        if(orderStatusStr != null){
            orderStatus = Integer.parseInt(orderStatusStr);
        }
        model.addAttribute("orderListInfos",orderService.searchOrderListInfo( userId,orderHotelName,checkInTime,checkOutTime,orderStatus));
        return "myorder";
    }
    @GetMapping(value = "/delete")
    @ResponseBody
    public boolean deleteOrder(@RequestParam("orderId") String orderId){
        orderListMapper.deleteByPrimaryKey(orderId);
        return true;
    }
    @PutMapping(value = "/unorder")
    @ResponseBody
    public boolean unOrder(@RequestParam("orderId") String orderId){
        System.out.println(orderId);
        OrderList orderList = orderListMapper.selectByPrimaryKey(orderId);
        Byte status=4;
        orderList.setStatus(status);
        orderListMapper.updateByPrimaryKey(orderList);
        return true;
    }
}
