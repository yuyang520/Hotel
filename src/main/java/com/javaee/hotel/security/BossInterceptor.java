package com.javaee.hotel.security;


import com.javaee.hotel.domain.Manager;
import com.javaee.hotel.mapper.ManagerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class BossInterceptor implements HandlerInterceptor {
    @Autowired
    private ManagerMapper managerMapper;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler)throws Exception {
//        System.out.println("PRE"+request.getRequestURL());
        try {
            Object username = request.getSession().getAttribute("username");
//        Manager manager = managerService.findManagerByPrimaryKey(username.toString());
            Manager manager = managerMapper.selectByPrimaryKey(username.toString());
            String privilege = manager.getPrivilege().toString();
            if (privilege.equals("3")) {
                return true;
            } else {
                response.sendRedirect("/tip");
                return false;
            }
        }catch(java.lang.NullPointerException e){
            response.sendRedirect("/ManagerLogin");
        }
        return false;
    }
}
