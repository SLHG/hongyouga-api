package com.cn.web.config;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RequestHandlerInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = Logger.getLogger(RequestHandlerInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        LOGGER.info(request.getRequestURI() + "=>请求数据:" + JSON.toJSONString(request.getParameterMap()));
        return true;
    }
}
