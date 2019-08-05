package com.javaee.hotel.alipay.trade.page;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.javaee.hotel.domain.Hotel;
import com.javaee.hotel.domain.OrderList;
import com.javaee.hotel.domain.OrderListExample;
import com.javaee.hotel.domain.Room;
import com.javaee.hotel.mapper.HotelMapper;
import com.javaee.hotel.mapper.OrderListMapper;
import com.javaee.hotel.mapper.RoomMapper;
import com.javaee.hotel.service.MOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Controller
@RequestMapping(value = "/alipay")
public class alipay implements AlipayInterfaec{

    @Autowired
    private MOrderService mOrderService;
    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private HotelMapper hotelMapper;
    @Autowired
    private OrderListMapper orderListMapper;
    @RequestMapping("payout")
    public void goTopay(@RequestParam("orderId") String orderId,
                        HttpServletResponse response,
                        HttpServletRequest request,
                        Model model)throws ServletException, IOException{
        OrderList orderList = mOrderService.findOrderListByPrimaryKey(orderId);
        Room room = roomMapper.selectByPrimaryKey(orderList.getRoomId());
        Hotel hotel = hotelMapper.selectByPrimaryKey(orderList.getHotelId());
        model.addAttribute("orderList",orderList);
        String subject ="预定酒店:"+hotel.getHotelChineseName()+">房间:"+room.getChineseName()+">数量:"+orderList.getRoomNumber();
        AlipayClient alipayClient = new DefaultAlipayClient(gatewayUrl, app_id, merchant_private_key, format, charset,
                alipay_public_key, sign_type); // 获得初始化的AlipayClient
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();// 创建API对应的request
        alipayRequest.setReturnUrl(return_url);
        alipayRequest.setNotifyUrl(notify_url);// 在公共参数中设置回跳和通知地址
        Date date = new Date();
        alipayRequest.setBizContent("{" +
                "\"out_trade_no\":\""+orderList.getOrderId()+"\"," +
                "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
                "\"total_amount\":"+orderList.getPrice()+"," +
                "\"subject\":\""+subject+"\"," +
                "\"body\":\""+subject+"\"," +
                "\"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\"," +
                "\"extend_params\":{" +
                "\"sys_service_provider_id\":\"2088511833207846\""+
                "}"+
                "}");//填充业务参数
        String form = "";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); // 调用SDK生成表单
        } catch (AlipayApiException e) { e.printStackTrace(); }
        response.setContentType("text/html;charset=" + charset);
        response.getWriter().write(form);// 直接将完整的表单html输出到页面
        response.getWriter().flush();
        response.getWriter().close();
    }
    @RequestMapping(value = "checkPay")
    public String checkPay(HttpServletRequest request) {
        String orderId = request.getParameter("out_trade_no");
        String serialNumber = request.getParameter("trade_no");
        OrderList orderList = new OrderList();
        orderList.setStatus((byte)2);
        orderList.setOrderId(orderId);
        orderList.setSerialNumber(serialNumber);
        orderListMapper.updateByPrimaryKeySelective(orderList);
        return "redirect:/myorder";
    }
}

