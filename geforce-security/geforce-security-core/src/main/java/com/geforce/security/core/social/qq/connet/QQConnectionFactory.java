package com.geforce.security.core.social.qq.connet;

import com.geforce.security.core.social.qq.api.QQ;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;

/**
 * @author geforce
 * @date 2017/11/17
 */
public class QQConnectionFactory extends OAuth2ConnectionFactory<QQ>{
    public QQConnectionFactory(String providerId,String appId,String appSecret){
        super(providerId,new QQServiceProvider(appId,appSecret),new QQAdapter());
    }

}
