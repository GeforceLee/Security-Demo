package com.geforce.security.core.social.weixin.api;

/**
 * 微信API调用接口
 *
 * @author geforce
 * @date 2017/11/21
 */
public interface Weixin {


    WeixinUserInfo getUserInfo(String openId);

}
