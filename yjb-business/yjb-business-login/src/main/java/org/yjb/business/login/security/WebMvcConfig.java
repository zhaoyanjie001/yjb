package org.yjb.business.login.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
 
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        HandlerInterceptor myInterceptor = new MyInterceptor();
        registry.addInterceptor(myInterceptor).addPathPatterns("/**").
        excludePathPatterns(
        		"/api/user/*"
        )
        ;
        
    }

    private class MyInterceptor implements HandlerInterceptor {
        // 实现你的拦截器逻辑
    }
}
