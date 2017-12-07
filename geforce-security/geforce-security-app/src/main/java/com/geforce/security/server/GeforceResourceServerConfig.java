package com.geforce.security.server;

import com.geforce.security.app.authentication.openid.OpenIdAuthenticationSecurityConfig;
import com.geforce.security.core.authentication.FormAuthenticationConfig;
import com.geforce.security.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.geforce.security.core.authorize.AuthorizeConfigManager;
import com.geforce.security.core.validate.code.ValidateCodeSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * 资源服务器配置
 *
 * @author geforce
 * @date 2017/12/7
 */
@Configuration
@EnableResourceServer
public class GeforceResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    protected AuthenticationSuccessHandler geAuthenticationSuccessHandler;

    @Autowired
    protected AuthenticationFailureHandler geAuthenticationFailureHandler;

    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

    @Autowired
    private OpenIdAuthenticationSecurityConfig openIdAuthenticationSecurityConfig;

    @Autowired
    private ValidateCodeSecurityConfig validateCodeSecurityConfig;

    @Autowired
    private SpringSocialConfigurer geforceSocialConfig;

    @Autowired
    private AuthorizeConfigManager authorizeConfigManager;

    @Autowired
    private FormAuthenticationConfig formAuthenticationConfig;


    @Override
    public void configure(HttpSecurity http) throws Exception {

        formAuthenticationConfig.configure(http);

        http.apply(validateCodeSecurityConfig)
                .and()
            .apply(smsCodeAuthenticationSecurityConfig)
                .and()
            .apply(geforceSocialConfig)
                .and()
            .apply(openIdAuthenticationSecurityConfig)
                .and()
            .csrf().disable();

        authorizeConfigManager.config(http.authorizeRequests());
    }
}
