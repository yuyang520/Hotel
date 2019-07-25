package com.javaee.hotel.service;

import com.javaee.hotel.domain.Order;
import com.javaee.hotel.domain.OrderExample;
import com.javaee.hotel.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Service
public class MOrderService {
    @Autowired
    private OrderMapper orderMapper;
    @RequestMapping( value = {"/orderlist.json"}, method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Order> orderlistRespond(){
        OrderExample example = new OrderExample();
        OrderExample.Criteria criteria = example.createCriteria();
        criteria.andOrderIdIsNotNull();
        return orderMapper.selectByExample(example);
    }
}
