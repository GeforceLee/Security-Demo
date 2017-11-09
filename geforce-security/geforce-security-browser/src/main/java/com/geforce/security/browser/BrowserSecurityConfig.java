package com.geforce.security.browser;

import com.geforce.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @author geforce
 * @date 2017/11/9
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private AuthenticationSuccessHandler geAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler geAuthenticationFailureHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
//                .httpBasic()
            .formLogin()
                .loginPage("/authentication/require")
                .loginProcessingUrl("/authentication/form")
                .successHandler(geAuthenticationSuccessHandler)
                .failureHandler(geAuthenticationFailureHandler)
                .and()
            .authorizeRequests()
                .antMatchers("/authentication/require", securityProperties.getBrowser().getLoginPage())
                .permitAll()
            .anyRequest()
                .authenticated()
                .and()
            .csrf().disable();

    }
}