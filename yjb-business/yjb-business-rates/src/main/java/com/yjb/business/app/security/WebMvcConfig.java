package com.yjb.business.app.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
//	@Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**") // 允许跨域的路径
//                        .allowedOrigins("*") // 允许跨域请求的域名
//                        .allowedMethods("GET", "POST", "PUT", "DELETE") // 允许的请求方法
//                        .allowedHeaders("*") // 允许的请求头
//                        .allowCredentials(true); // 是否允许证书（cookies）
//            }
//        };
//    }
	
	 
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        HandlerInterceptor myInterceptor = new MyInterceptor();
        registry.addInterceptor(myInterceptor).addPathPatterns("/**").
        excludePathPatterns(
        		"/api/books/*"
        )
        ;
        
    }

    private class MyInterceptor implements HandlerInterceptor {
        // 实现你的拦截器逻辑
    }
}
