package com.geforce.security.core.authorize;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

/**
 * 授权信息管理器
 *
 * 用于收集系统中所有 AuthorizeConfigProvider 并加载其配置
 *
 * @author geforce
 * @date 2017/11/25
 */
public interface AuthorizeConfigManager {

    void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config);

}
