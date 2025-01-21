package com.yjb.business.app.security;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class HeaderInterceptor extends HandlerInterceptorAdapter {
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 设置Header的响应信息
        response.addHeader("Content-Type", "application/json; charset=utf-8");
        response.addHeader("Content-Encoding", "gzip");
        response.addHeader("Date", new Date().toString());
        return true;
    }
}
