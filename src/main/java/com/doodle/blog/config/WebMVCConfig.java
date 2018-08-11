package com.doodle.blog.config;

import com.doodle.blog.interceptor.LoginHandlerInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;

@Component
public class WebMVCConfig extends WebMvcConfigurationSupport {

    @Resource
    private LoginHandlerInterceptor loginHandlerInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(loginHandlerInterceptor);
    }
}
