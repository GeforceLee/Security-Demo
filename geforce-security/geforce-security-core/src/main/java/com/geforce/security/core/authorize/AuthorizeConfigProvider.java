package com.geforce.security.core.authorize;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

/**
 * 授权配置提供器,各个业务模块和业务系统可以通过实现此接口像系统添加授权配置
 *
 *
 * @author geforce
 * @date 2017/11/25
 */
public interface AuthorizeConfigProvider {


    /**
     *
     * @param config
     * @return 返回的boolean表示配置中是否有针对anyRequest的配置.
     * 在整个配置授权中,应该有且只有一个针对anyRequest的配置,如果所有
     * 的实现都没有针对anyRequest的配置,系统会自动增加一个anyRequest().authenticated()
     * 的配置.如果有多个针对anyRequest的配置,则会抛出异常
     */
    boolean config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config);

}
