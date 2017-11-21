package com.geforce.security.core.social.support;

import org.springframework.social.security.SocialAuthenticationFilter;

/**
 * SocialAuthenticationFilter后处理器,用于在不同环境下个性社交登录的配置
 *
 * @author geforce
 * @date 2017/11/21
 */
public interface SocialAuthenticationFilterPostProcessor {


    void process(SocialAuthenticationFilter socialAuthenticationFilter);

}
