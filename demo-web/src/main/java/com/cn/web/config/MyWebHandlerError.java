package com.cn.web.config;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyWebHandlerError implements HandlerExceptionResolver {

    private static final Logger LOGGER = Logger.getLogger(MyWebHandlerError.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        LOGGER.error("系统报错", e);
        ModelAndView error = new ModelAndView(new MappingJackson2JsonView());
        error.addObject("message", "系统出错");
        return error;
    }
}
