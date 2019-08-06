package com.javaee.hotel.alipay.trade.page;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.javaee.hotel.domain.OrderList;
import com.javaee.hotel.mapper.OrderListMapper;
import com.javaee.hotel.service.MOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

@Controller
@RequestMapping(value = "/alipay")
public class refund implements AlipayInterfaec{
    @Autowired
    private MOrderService mOrderService;
    @Autowired
    private OrderListMapper orderListMapper;
    @RequestMapping(value = "/refund", method = RequestMethod.GET)
    public String refund(@RequestParam("orderId") String orderId)
            throws ServletException, IOException{
        AlipayClient alipayClient = new DefaultAlipayClient(gatewayUrl, app_id, merchant_private_key, format, charset,
                alipay_public_key, sign_type); // 获得初始化的AlipayClient
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        OrderList orderList = mOrderService.findOrderListByPrimaryKey(orderId);
        NumberFormat formatter = new DecimalFormat("0.00");
        String formmatedFloatValue = formatter.format(orderList.getPrice());
        request.setBizContent("{" +
                "\"out_trade_no\":\""+orderList.getOrderId()+"\"," +
                "\"trade_no\":\""+orderList.getSerialNumber()+"\"," +
                "\"out_request_no\":\"HZ01RF001\"," +
                "\"refund_amount\":"+formmatedFloatValue+"," +
                "\"biz_type\":\"CREDIT_REFUND\"," +
                "\"refund_reason\":\"正常退款\"," +
                "\"operator_id\":\"OP001\"," +
                "\"store_id\":\"NJ_S_001\"," +
                "\"terminal_id\":\"NJ_T_001\"" +
                "  }");
        try {
            AlipayTradeRefundResponse response = alipayClient.execute(request);
            if(response.isSuccess()){
                response = alipayClient.execute(request);
                if(response.isSuccess()){
                    String tradeNo = response.getTradeNo();
                    String orderIdResponse = response.getOutTradeNo();
                    OrderList orderListResponse = mOrderService.findOrderListByPrimaryKey(orderIdResponse);
                    boolean amountCheck = Math.abs(orderListResponse.getPrice()-Float.parseFloat(response.getRefundFee()))<0.01;
                    boolean statusCheck = orderListResponse.getStatus()==(byte)2;
                    if(statusCheck&&amountCheck) {
                        orderListResponse.setStatus((byte)4);
                        orderListMapper.updateByPrimaryKey(orderListResponse);
                    }
                }
                return "redirect:/myorder";
            } else {
                System.out.println("调用失败");
            }
        } catch (AlipayApiException e) { e.printStackTrace(); }
        return "redirect:/myorder";
    }

}
