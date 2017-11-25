package com.geforce.security.core.authentication;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUserDetailsService;

/**
 * 认证相关的扩展点配置,配置在这里的Bean,
 * 业务系统都可以通过声明的同类型或同名的bean来
 * 覆盖安全模块默认的配置
 *
 *
 *
 * @author geforce
 * @date 2017/11/25
 */
@Configuration
public class AuthenticationBeanConfig {
    /**
     * 默认的密码处理器
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(PasswordEncoder.class)
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 默认认证器
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(UserDetailsService.class)
    public UserDetailsService userDetailsService() {
        return new DefaultUserDetailsService();
    }

    /**
     * 默认认证器
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(SocialUserDetailsService.class)
    public SocialUserDetailsService socialUserDetailsService(){
        return new DefaultSocialUserDetailService();
    }

}
