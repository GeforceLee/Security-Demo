package com.geforce.security.core.properties;

import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * 微信登录配置项
 *
 * @author geforce
 * @date 2017/11/20
 */
public class WeixinProperties extends SocialProperties{

    /**
     * 第三方id,用来解决发起第三方登录的url,默认是 weixin
     */
    private String providerId = "weixin";

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }
}
