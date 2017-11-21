package com.geforce.security.core.social.weixin.connect;

import org.springframework.social.oauth2.AccessGrant;

/**
 * 微信的access_token信息,与标准OAuth2协议不同,微信在获取access_token时同时会返回openId,
 * 并没有单通的通过access_token获取openId的服务
 *
 * 所以在这里继承了标准的AccessGrant,添加了openId字段,作为对微信access_token信息的封装
 *
 * @author geforce
 * @date 2017/11/21
 */
public class WeixinAccessGrant extends AccessGrant {

    private String openId;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }


    public WeixinAccessGrant() {
        super("");
    }


    public WeixinAccessGrant(String accessToken,String scope,String refreshToken,Long expiresIn){
        super(accessToken, scope, refreshToken, expiresIn);
    }
}
