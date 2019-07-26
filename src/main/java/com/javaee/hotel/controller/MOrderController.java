package com.javaee.hotel.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSON;
import com.javaee.hotel.domain.Order;
import com.javaee.hotel.domain.OrderList;
import com.javaee.hotel.service.MOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @ResponseBody
    public List<OrderList> getOrderListJson() {
        System.out.println(mOrderService.orderlistRespond());
        System.out.println(mOrderService.orderlistRespond());
        return mOrderService.orderlistRespond();
    }

    @GetMapping("/add")
    public String goOrderPage(Model model){
        model.addAttribute("orderList",new OrderList());
        return "order-add";
    }



    @PostMapping("/add")
    public String saveorder(OrderList orderList){
        mOrderService.saveorder(orderList);

        return "redirect:/MOrderlist";
    }

    @GetMapping("/edit")
    public String goorderEditPage(@RequestParam("orderId") String orderId, Model model){
         OrderList orderList = mOrderService.findOrderListByPrimaryKey(orderId);
         model.addAttribute("orderList",orderList);
        return "order-add";
    }


//    @GetMapping()
//    public String deleteOrer(@RequestParam("orderId") String orderId){
//        mOrderService.deleteOrderById(orderId);
//        return "redirect:/MOrderlist";
//    }

}
