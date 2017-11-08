package com.geforce.web.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author geforce
 * @date 2017/11/8
 */
@Component
public class TimeInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(TimeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("TimeInterceptor per handle");
        logger.info(((HandlerMethod)handler).getBean().getClass().getName());
        logger.info(((HandlerMethod)handler).getMethod().getName());
        request.setAttribute("startTime",System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("postHandle");
        Long start = (Long) request.getAttribute("startTime");
        logger.info("time interceptor 耗时:"+ (System.currentTimeMillis() - start));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("afterCompletion");
        Long start = (Long) request.getAttribute("startTime");
        logger.info("time interceptor 耗时:"+ (System.currentTimeMillis() - start));
        logger.info("ex is "+ex);
    }
}
