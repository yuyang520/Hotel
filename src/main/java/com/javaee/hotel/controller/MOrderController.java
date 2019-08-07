package com.javaee.hotel.controller;

import com.javaee.hotel.domain.OrderList;
import com.javaee.hotel.service.MOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/MOrderlist")
public class MOrderController {
    @Autowired
    private MOrderService mOrderService;


    @GetMapping("")
    public String MOrderHtml(HttpServletRequest request,
                             HttpServletResponse response,
                             Model model){

        Boolean isLogin = request.getSession().getAttribute("username") !=null ;
        model.addAttribute("isLogin",isLogin);
        return "/MOrderlist";
    }


    @InitBinder
    protected void init( HttpServletRequest request, ServletRequestDataBinder binder ) {
        SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd hh:mm:ss" );
        dateFormat.setLenient( false );
        binder.registerCustomEditor( Date.class, new CustomDateEditor( dateFormat, false ) );
    }


    @GetMapping(value = "/orderlist.json",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<OrderList> getOrderListJson() {
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


    @PostMapping("/deleteOrder")
    @ResponseBody
    public boolean deleteOrer(@RequestParam("orderId") String orderId){
        mOrderService.deleteOrderById(orderId);
        return true;
    }

    @PostMapping("/exit")
    @ResponseBody
    public Boolean LogOut(HttpServletResponse response,
                         HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return true;
    }
}
