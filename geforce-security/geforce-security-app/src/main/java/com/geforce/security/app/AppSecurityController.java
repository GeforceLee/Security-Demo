package com.geforce.security.app;

import com.geforce.security.app.social.AppSignUpUtils;
import com.geforce.security.core.properties.SecurityConstants;
import com.geforce.security.core.social.SocialController;
import com.geforce.security.core.social.support.SocialUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;

/**
 *
 *
 * @author geforce
 * @date 2017/12/5
 */
@RestController
public class AppSecurityController extends SocialController{

    @Autowired
    private ProviderSignInUtils providerSignInUtils;

    @Autowired
    private AppSignUpUtils appSignUpUtils;

    /**
     * 需要注册时跳转到这里,返回401和用户信息给前端
     *
     * @param request
     * @return
     */
    @GetMapping(SecurityConstants.DEFAULT_SOCIAL_USER_INFO_URL)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public SocialUserInfo getSocialUserInfo(HttpServletRequest request){
        Connection<?> connection = providerSignInUtils.getConnectionFromSession(new ServletWebRequest(request));
        appSignUpUtils.saveConnectionData(new ServletWebRequest(request),connection.createData());
        return buildSocialUserInfo(connection);
    }

}
