package com.geforce.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author geforce
 * @date 2017/11/8
 */
@Aspect
@Component
public class TimeAspect {

    private Logger logger = LoggerFactory.getLogger(TimeAspect.class);

    @Pointcut("execution(* com.geforce.web.controller.UserController.*(..)) || execution(* com.geforce.web.async.AsyncController.*(..))")
    public void usercontroller(){}

    @Around(value = "usercontroller()")
    public Object handleControllerMethod(ProceedingJoinPoint point) throws Throwable {
        logger.info("time aspect start ");

        Object[] args = point.getArgs();
        for (Object arg : args) {
            logger.info("arg is "+ arg);
        }


        long start = System.currentTimeMillis();

        Object object = point.proceed();

        logger.info("time aspect 耗时:"+ (System.currentTimeMillis() - start));

        logger.info("time aspect end");

        return object;
    }



}

