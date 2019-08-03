package com.javaee.hotel.security;

import com.javaee.hotel.domain.Manager;
import com.javaee.hotel.mapper.ManagerMapper;
import com.javaee.hotel.service.ManagerService;
import org.apache.ibatis.javassist.bytecode.stackmap.BasicBlock;
import org.apache.ibatis.plugin.Intercepts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Service
public class AddHotelAndRoomInterceptor implements HandlerInterceptor {

//    private ManagerService managerService;

    @Autowired
    private ManagerMapper managerMapper;
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler)throws Exception{
//        System.out.println("PRE"+request.getRequestURL());
        try {
            Object username = request.getSession().getAttribute("username");
//        Manager manager = managerService.findManagerByPrimaryKey(username.toString());
            Manager manager = managerMapper.selectByPrimaryKey(username.toString());
            String privilege = manager.getPrivilege().toString();
            if (privilege.equals("1")) {
                response.sendRedirect("/tip");
                return false;
            } else {
                return true;
            }
        } catch(java.lang.NullPointerException e){
            response.sendRedirect("/ManagerLogin");
        }
        return false;
    }



}
