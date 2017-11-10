package com.geforce.security.core.authentication.sms;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.bind.ServletRequestUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author geforce
 * @date 2017/11/10
 */
public class SmsCodeAuthenticationFilter extends AbstractAuthenticationProcessingFilter {


    protected SmsCodeAuthenticationFilter() {
        super(new AntPathRequestMatcher("/authentication/mobile","POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        if (!StringUtils.equalsIgnoreCase("POST",request.getMethod())){
            throw new AuthenticationServiceException("登录请求值支持POST方法");
        }

        String mobile = ServletRequestUtils.getStringParameter(request,"mobile");

        if (StringUtils.isBlank(mobile)) {
            throw new AuthenticationServiceException("手机号不能为空");
        }

        SmsCodeAuthenticationToken authRequest = new SmsCodeAuthenticationToken(mobile);

        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));

        return getAuthenticationManager().authenticate(authRequest);
    }
}
