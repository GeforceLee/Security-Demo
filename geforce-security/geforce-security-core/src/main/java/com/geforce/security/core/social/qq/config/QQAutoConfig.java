package com.geforce.security.core.social.qq.config;

import com.geforce.security.core.properties.QQProperties;
import com.geforce.security.core.properties.SecurityProperties;
import com.geforce.security.core.social.qq.connet.QQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;

/**
 * @author geforce
 * @date 2017/11/17
 */
@Configuration
@ConditionalOnProperty(prefix = "geforce.security.social.qq",name="app-id")
public class QQAutoConfig extends SocialAutoConfigurerAdapter{
    @Autowired
    private SecurityProperties securityProperties;

    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        QQProperties qqConfig = securityProperties.getSocial().getQq();

        return new QQConnectionFactory(qqConfig.getProviderId(),qqConfig.getAppId(),qqConfig.getAppSecret());
    }
}
