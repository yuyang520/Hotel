package com.javaee.hotel.alipay.trade.page;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;

import com.javaee.hotel.domain.Hotel;
import com.javaee.hotel.domain.OrderList;
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
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
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
        Map<String, String> paramsMap = new HashMap<String,String>();
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String paramName = (String) enu.nextElement();

            String paramValue = request.getParameter(paramName);
            paramsMap.put(paramName, paramValue);
        }
        try {
            boolean signVerified = AlipaySignature.rsaCheckV1(paramsMap, alipay_public_key, charset, sign_type);
            if( signVerified) {
                OrderList orderList = orderListMapper.selectByPrimaryKey(paramsMap.get("out_trade_no"));
                orderList.setSerialNumber(paramsMap.get("trade_no"));
                boolean amountCheck = Math.abs(orderList.getPrice()-Float.parseFloat(paramsMap.get("total_amount")))<0.01;
                boolean statusCheck = orderList.getStatus()==(byte)1;
                if(amountCheck&&statusCheck) {
                    orderList.setStatus((byte)2);
                    orderListMapper.updateByPrimaryKey(orderList);
                }
            }
            return "redirect:/myorder";
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return "redirect:/myorder";
    }
}

