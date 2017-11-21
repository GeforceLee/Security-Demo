package com.geforce.security.core.social.weixin.config;

import com.geforce.security.core.properties.SecurityProperties;
import com.geforce.security.core.properties.SessionProperties;
import com.geforce.security.core.properties.WeixinProperties;
import com.geforce.security.core.social.view.GeforceConnectView;
import com.geforce.security.core.social.weixin.connect.WeixinConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.web.servlet.View;

/**
 * 微信登录配置
 *
 * @author geforce
 * @date 2017/11/21
 */
@Configuration
@ConditionalOnProperty(prefix = "geforce.security.social.weixin", name = "app-id")
public class WeixinAutoConfiguration extends SocialAutoConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;


    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        WeixinProperties weixinProperties = securityProperties.getSocial().getWeixin();
        return new WeixinConnectionFactory(weixinProperties.getProviderId(), weixinProperties.getAppId(), weixinProperties.getAppSecret());
    }

    @Bean({"connect/weixinConnect", "connect/weixinConnected"})
    @ConditionalOnMissingBean(name = "weixinCOnnectedView")
    public View weixinConnectedView() {
        return new GeforceConnectView();
    }


}
