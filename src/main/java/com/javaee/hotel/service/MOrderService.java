package com.javaee.hotel.service;

import com.javaee.hotel.domain.Order;
import com.javaee.hotel.domain.OrderExample;
import com.javaee.hotel.domain.OrderList;
import com.javaee.hotel.domain.OrderListExample;
import com.javaee.hotel.mapper.OrderListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class MOrderService {
    @Autowired
    private OrderListMapper orderListMapper;

    public List<OrderList> orderlistRespond(){
        OrderListExample example = new OrderListExample();
        return orderListMapper.selectByExample(example);
    }


    public Integer saveorder(OrderList orderList){
        if(orderList.getOrderId() == null){
            return  orderListMapper.insert(orderList);
        }else {
            return orderListMapper.updateByPrimaryKey(orderList);
        }
    }

    public OrderList findOrderListByPrimaryKey(String orderId){

        return orderListMapper.selectByPrimaryKey(orderId);
    }

    public void deleteOrderById(String orderId) {

        orderListMapper.deleteByPrimaryKey(orderId);
    }
}
