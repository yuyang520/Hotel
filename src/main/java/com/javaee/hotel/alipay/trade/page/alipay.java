package com.javaee.hotel.alipay.trade.page;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.javaee.hotel.domain.OrderList;
import com.javaee.hotel.service.MOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value = "/alipay")
public class alipay implements AlipayInterfaec{

    @Autowired
    private MOrderService mOrderService;

    @RequestMapping(value = "/pay", method = RequestMethod.GET)
    public void pay(HttpServletRequest httpRequest, HttpServletResponse httpResponse)
            throws ServletException, IOException {
//        AlipayClient alipayClient = new DefaultAlipayClient(gatewayUrl, app_id, merchant_private_key, format, charset,
//                alipay_public_key, sign_type); // 获得初始化的AlipayClient
//        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();// 创建API对应的request
//        alipayRequest.setReturnUrl(return_url);
//        alipayRequest.setNotifyUrl(notify_url);// 在公共参数中设置回跳和通知地址
//        alipayRequest.setBizContent("{" + "    \"out_trade_no\":\"2015032001010100"+(int)(Math.random()*1000)
//                +"\"," + "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," + "    \"total_amount\":"
//                +18888+"," + "    \"subject\":\"王者荣耀新英雄：西施\"," + "  \"body\":\"王者荣耀新英雄\","
//                + "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\","
//                + "    \"extend_params\":{" + "    \"sys_service_provider_id\":\"2088511833207846\""
//                + "    }" + "  }");// 填充业务参数
//        String form = "";
//
//        try {
//            form = alipayClient.pageExecute(alipayRequest).getBody(); // 调用SDK生成表单
//        } catch (AlipayApiException e) { e.printStackTrace(); }
//        httpResponse.setContentType("text/html;charset=" + charset);
//        httpResponse.getWriter().write(form);// 直接将完整的表单html输出到页面
//        httpResponse.getWriter().flush();
//        httpResponse.getWriter().close();
    }


    @RequestMapping("payout")
    public void goTopay(@RequestParam("orderId") String orderId,
                        HttpServletResponse response,
                        HttpServletRequest request,
                        Model model)throws ServletException, IOException{
        OrderList orderList = mOrderService.findOrderListByPrimaryKey(orderId);
        model.addAttribute("orderList",orderList);


        AlipayClient alipayClient = new DefaultAlipayClient(gatewayUrl, app_id, merchant_private_key, format, charset,
                alipay_public_key, sign_type); // 获得初始化的AlipayClient
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();// 创建API对应的request
        alipayRequest.setReturnUrl(return_url);
        alipayRequest.setNotifyUrl(notify_url);// 在公共参数中设置回跳和通知地址
//        alipayRequest.setBizContent("{" + "    \"out_trade_no\":\"2015032001010100"+(int)(Math.random()*1000)
//                +"\"," + "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," + "    \"total_amount\":"
//                +orderList.getPrice().toString()+"," + "    \"subject\":\"王者荣耀新英雄：西施\"," + "  \"body\":\"王者荣耀新英雄\","
//                + "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\","
//                + "    \"extend_params\":{" + "    \"sys_service_provider_id\":\"2088511833207846\""
//                + "    }" + "  }");// 填充业务参数
        alipayRequest.setBizContent("{" +
                "    \"out_trade_no\":\"20150320010101001\"," +
                "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
                "    \"total_amount\":88.88," +
                "    \"subject\":\"Iphone6 16G\"," +
                "    \"body\":\"Iphone6 16G\"," +
                "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\"," +
                "    \"extend_params\":{" +
                "    \"sys_service_provider_id\":\"2088511833207846\"" +
                "    }"+
                "  }");//填充业务参数

        String form = "";

        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); // 调用SDK生成表单
        } catch (AlipayApiException e) { e.printStackTrace(); }
        response.setContentType("text/html;charset=" + charset);
        response.getWriter().write(form);// 直接将完整的表单html输出到页面
        response.getWriter().flush();
        response.getWriter().close();


    }
}

