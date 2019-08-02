package com.javaee.hotel.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class BossConfig implements WebMvcConfigurer {
    @Bean
    public HandlerInterceptor BossInterceptor(){
        return  new BossInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){

        registry.addInterceptor(BossInterceptor())
                .addPathPatterns("/manager/**");
    }

}
