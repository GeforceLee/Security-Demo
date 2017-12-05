package com.geforce.security.browser;

import com.geforce.security.browser.logout.GeforceLogoutSuccessHandler;
import com.geforce.security.browser.session.GeforceExpiredSessionStrategy;
import com.geforce.security.browser.session.GeforceInvalidSessionStrategy;
import com.geforce.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

/**
 * 浏览器环境下扩展的配置,配置在这里的bean,业务系统都可以通过声明同类型或同名的bean来覆盖
 * 安全模块的默认的配置
 *
 * @author geforce
 * @date 2017/12/4
 */
@Configuration
public class BrowserSecurityBeanConfig {

    @Autowired
    private SecurityProperties securityProperties;


    /**
     * session 失效时的处理策略配置
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(InvalidSessionStrategy.class)
    public InvalidSessionStrategy invalidSessionStrategy(){
        return new GeforceInvalidSessionStrategy(securityProperties);
    }

    /**
     * 并发登录导致前一个session失效时的处理策略配置
     *
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(SessionInformationExpiredStrategy.class)
    public SessionInformationExpiredStrategy sessionInformationExpiredStrategy(){
        return new GeforceExpiredSessionStrategy(securityProperties);
    }

    /**
     * 退出时的处理策略配置
     *
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(LogoutSuccessHandler.class)
    public LogoutSuccessHandler logoutSuccessHandler(){
        return new GeforceLogoutSuccessHandler(securityProperties.getBrowser().getSignOutUrl());
    }
}
