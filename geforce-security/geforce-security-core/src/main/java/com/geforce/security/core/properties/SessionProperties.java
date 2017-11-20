package com.geforce.security.core.properties;

/**
 * session管理相关配置项
 *
 * @author geforce
 * @date 2017/11/20
 */
public class SessionProperties {

    /**
     * 同一个用户在系统中的最大session数,默认是1
     */
    private int maximumSessions = 1;

    /**
     * 达到最大session时是否阻止新的请求登录,默认为false,不阻止,新的登录会将老的登录失效掉
     */
    private boolean maxSessionPreventsLogin;

    /**
     * session失效时跳转的地址
     */
    private String sessionInvalidUrl = SecurityConstants.DEFAULT_SESSION_INVALID_URL;


    public int getMaximumSessions() {
        return maximumSessions;
    }

    public void setMaximumSessions(int maximumSessions) {
        this.maximumSessions = maximumSessions;
    }

    public boolean isMaxSessionPreventsLogin() {
        return maxSessionPreventsLogin;
    }

    public void setMaxSessionPreventsLogin(boolean maxSessionPreventsLogin) {
        this.maxSessionPreventsLogin = maxSessionPreventsLogin;
    }

    public String getSessionInvalidUrl() {
        return sessionInvalidUrl;
    }

    public void setSessionInvalidUrl(String sessionInvalidUrl) {
        this.sessionInvalidUrl = sessionInvalidUrl;
    }
}
