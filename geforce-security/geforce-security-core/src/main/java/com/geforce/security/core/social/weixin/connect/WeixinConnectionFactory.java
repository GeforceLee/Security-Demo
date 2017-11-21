package com.geforce.security.core.social.weixin.connect;

import com.geforce.security.core.social.weixin.api.Weixin;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionData;
import org.springframework.social.connect.support.OAuth2Connection;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2ServiceProvider;

/**
 * 微信连接工厂
 * @author geforce
 * @date 2017/11/21
 */
public class WeixinConnectionFactory extends OAuth2ConnectionFactory<Weixin> {

    public WeixinConnectionFactory(String providerId,String appId,String appSecret){
        super(providerId,new WeixinServiceProvider(appId,appSecret),new WeixinAdapter());
    }

    /**
     * 由于微信的openId是和accessToken一起返回的,所以在这里直接根据accessToken设置providerUserId即可,
     * 不用像QQ那样通过哦QQAdapter来获取
     * @param accessGrant
     * @return
     */
    @Override
    protected String extractProviderUserId(AccessGrant accessGrant) {
        if (accessGrant instanceof WeixinAccessGrant) {
            return ((WeixinAccessGrant) accessGrant).getOpenId();
        }
        return null;
    }


    @Override
    public Connection<Weixin> createConnection(AccessGrant accessGrant) {
        return new OAuth2Connection<Weixin>(getProviderId(),extractProviderUserId(accessGrant)
                ,accessGrant.getAccessToken(),accessGrant.getRefreshToken(),
                accessGrant.getExpireTime(),getOAuth2ServiceProvider(),getApiAdapter(extractProviderUserId(accessGrant)));
    }



    @Override
    public Connection<Weixin> createConnection(ConnectionData data) {
        return super.createConnection(data);
    }


    private ApiAdapter<Weixin> getApiAdapter(String providerUserId) {
        return new WeixinAdapter(providerUserId);
    }

    private OAuth2ServiceProvider<Weixin> getOAuth2ServiceProvider() {
        return (OAuth2ServiceProvider<Weixin>) getServiceProvider();
    }
}
