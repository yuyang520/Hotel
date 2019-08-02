package com.javaee.hotel.security;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class  LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler)throws Exception{
//        System.out.println("PRE"+request.getRequestURL());
        Object username = request.getSession().getAttribute("username");
        if(username != null){
            return true;
        }else {
            response.sendRedirect("/ManagerLogin");
            return false;
        }
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)throws Exception{
//        System.out.println("POST"+request.getRequestURL());
    }
//    @Override
//    public void afterCompletion(HttpServletRequest request,HttpServletResponse response,Object handler ,Exception ex)throws Exception{
////        System.out.println("AFTER"+request.getRequestURL());
//    }
}

