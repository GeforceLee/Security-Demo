package com.geforce.security.core.authentication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;

/**
 * 默认的SocialUserDetailsService实现
 *
 * 不做任何处理,只在控制台打印一句话,然后抛出异常
 * 提醒业务系统自己配置SocialUserDetailService
 *
 * @author geforce
 * @date 2017/11/25
 */
public class DefaultSocialUserDetailService implements SocialUserDetailsService {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        logger.warn("请配置 SocialUserDetailsService 接口的实现");
        throw new UsernameNotFoundException(userId);
    }
}
