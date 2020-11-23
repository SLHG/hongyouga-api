package com.cn.config;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class RequestHandlerAspect {

    private static final Logger LOGGER = Logger.getLogger(RequestHandlerAspect.class);

    @Pointcut("execution(public * com.cn.web..*.*(..)))")
    public void requestAspect() {
    }

    @Before("requestAspect()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null) {
            return;
        }
        HttpServletRequest request = attributes.getRequest();
        LOGGER.info(request.getRequestURI() + "=>请求参数:" + JSON.toJSONString(request.getParameterMap()));
        Object[] args = joinPoint.getArgs();
        Object[] arguments = new Object[args.length];
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof ServletRequest || args[i] instanceof ServletResponse) {
                continue;
            }
            arguments[i] = args[i];
        }
        LOGGER.info(request.getRequestURI() + "=>方法接收参数:" + JSON.toJSONString(arguments));
    }

    @Around("requestAspect()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = proceedingJoinPoint.proceed();
        LOGGER.info("响应参数=>" + JSON.toJSONString(result));
        return result;
    }

}
