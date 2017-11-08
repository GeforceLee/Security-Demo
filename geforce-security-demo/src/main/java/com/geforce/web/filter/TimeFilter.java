package com.geforce.web.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * @author geforce
 * @date 2017/11/8
 */
//@Component
public class TimeFilter implements Filter{
    private Logger logger = LoggerFactory.getLogger(TimeFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("time filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("time filter start");
        long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        logger.info("time filter 耗时:"+ (System.currentTimeMillis() - start));
        logger.info("time filter finish");
    }

    @Override
    public void destroy() {
        logger.info("time filter destory");
    }
}
