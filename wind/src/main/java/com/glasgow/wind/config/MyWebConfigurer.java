package com.glasgow.wind.config;

import com.glasgow.wind.interceptor.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author Zhe Miao Guid: 2598803M
 * @Date 2021/11/25 20:14
 * @Version 1.0
 */

@Configuration
public class MyWebConfigurer implements WebMvcConfigurer {
    // 注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns("/**") 表示拦截所有的请求，
        // excludePathPatterns("/login", "/register") 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/album/create", "/rate/create");
        WebMvcConfigurer.super.addInterceptors(registry);
    }

}
