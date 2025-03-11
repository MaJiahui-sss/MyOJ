package com.mjh.myojpro.config;

import com.mjh.myojpro.interceptor.JWTInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor())
                .addPathPatterns("/user/ping")
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/user/register");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
