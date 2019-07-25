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
}
