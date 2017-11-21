package com.geforce.security.core.social;

import com.geforce.security.core.social.support.SocialUserInfo;
import org.springframework.social.connect.Connection;

/**
 * @author geforce
 * @date 2017/11/21
 */
public abstract class SocialController {

    /**
     * 根据Connection信息构建SOcialUserInfo
     * @param connection
     * @return
     */
    protected SocialUserInfo buildSocialUserInfo(Connection<?> connection) {
        SocialUserInfo userInfo = new SocialUserInfo();
        userInfo.setProviderId(connection.getKey().getProviderId());
        userInfo.setProviderUserId(connection.getKey().getProviderUserId());
        userInfo.setNickname(connection.getDisplayName());
        userInfo.setHeadimg(connection.getImageUrl());
        return userInfo;
    }

}
