package com.geforce.security.core.authentication;

import com.geforce.security.core.properties.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * 表单登录配置
 *
 * @author geforce
 * @date 2017/11/25
 */
@Component
public class FormAuthenticationConfig {

    @Autowired
    protected AuthenticationSuccessHandler geforceAuthenticationSuccessHandler;


    @Autowired
    protected AuthenticationFailureHandler geforceAuthenticationFailureHandler;


    public void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
                .loginProcessingUrl(SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_FORM)
                .successHandler(geforceAuthenticationSuccessHandler)
                .failureHandler(geforceAuthenticationFailureHandler);
    }
}
