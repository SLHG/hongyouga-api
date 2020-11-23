package com.cn.config;

import com.cn.beans.common.ResultBean;
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
        LOGGER.error(httpServletRequest.getRequestURI() + "=>系统报错:", e);
        ModelAndView error = new ModelAndView(new MappingJackson2JsonView());
        error.addObject("rtnCode", ResultBean.FAIL_CODE);
        error.addObject("rtnMsg", ResultBean.FAIL_MSG);
        return error;
    }
}
