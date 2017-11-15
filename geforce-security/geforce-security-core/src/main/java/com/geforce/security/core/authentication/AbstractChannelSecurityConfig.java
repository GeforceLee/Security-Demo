package com.geforce.security.core.authentication;

import com.geforce.security.core.properties.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @author geforce
 * @date 2017/11/15
 */
public class AbstractChannelSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    protected AuthenticationSuccessHandler geAuthenticationSuccessHandler;

    @Autowired
    protected AuthenticationFailureHandler geAuthenticationFailureHandler;

    protected void applyPasswordAuthenticationConfig(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.formLogin()
                .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
                .loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
                .successHandler(geAuthenticationSuccessHandler)
                .failureHandler(geAuthenticationFailureHandler);
    }

}
