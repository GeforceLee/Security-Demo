package com.geforce.security.browser.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geforce.security.core.properties.LoginResponseType;
import com.geforce.security.core.properties.SecurityProperties;
import com.geforce.security.core.support.SimpleResponse;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 浏览器环境下登录成功的处理器
 *
 * @author geforce
 * @date 2017/11/9
 */
@Component("geAuthenticationSuccessHandler")
public class GeAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SecurityProperties securityProperties;

    private RequestCache requestCache = new HttpSessionRequestCache();


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        logger.info("登陆成功");

        if (LoginResponseType.JSON.equals(securityProperties.getBrowser().getLoginType())) {
            response.setContentType("application/json;charset=UTF-8");
            String type = authentication.getClass().getSimpleName();
            response.getWriter().write(objectMapper.writeValueAsString(new SimpleResponse(type)));
        }else {
            //如果设置了signInSuccessUrl,总是跳转到设置的地址上
            //如果没有设置,则尝试跳转到登录之前访问的地址上,如果登录前访问的地址为空,则调到网站的根路径上
            if (StringUtils.isNotBlank(securityProperties.getBrowser().getSignInSuccessUrl())){
                requestCache.removeRequest(request,response);
                setAlwaysUseDefaultTargetUrl(true);
                setDefaultTargetUrl(securityProperties.getBrowser().getSignInSuccessUrl());
            }

            super.onAuthenticationSuccess(request, response, authentication);
        }



    }
}
