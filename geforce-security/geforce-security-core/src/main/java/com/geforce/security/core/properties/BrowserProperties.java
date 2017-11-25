package com.geforce.security.core.properties;

/**
 * 浏览器环境配置项
 *
 * @author geforce
 * @date 2017/11/9
 */
public class BrowserProperties {

    /**
     * session管理配置项
     */
    private SessionProperties session = new SessionProperties();



    /**
     * 登录页面,当引发登录行为的url以html结尾时,会跳到这里配置的url上
     */
    private String signInPage = SecurityConstants.DEFAULT_SIGN_IN_PAGE_URL;

    /**
     * '记住我'功能的有效时间,默认1小时
     */
    private int rememberMeSeconds = 3600;

    /**
     * 退出成功时跳转的url,如果配置了,则跳转到制定的url,如果没有配置,则返回json数据
     */
    private String signOutUrl;

    /**
     * 社交登录,如果需要用户注册,跳转的页面
     */
    private String signUpUrl = "/geforce-signUp.html";

    /**
     * 登录响应的方式,默认是json
     */
    private LoginResponseType loginType = LoginResponseType.JSON;

    /**
     * 登录成功后跳转的地址,如果设置了此属性,则登录成功后总是会跳转到这个地址上.
     *
     * 只在signInResponseType 为 REDIRECT时生效
     */
    private String signInSuccessUrl;


    public SessionProperties getSession() {
        return session;
    }

    public void setSession(SessionProperties session) {
        this.session = session;
    }

    public String getSignInPage() {
        return signInPage;
    }

    public void setSignInPage(String signInPage) {
        this.signInPage = signInPage;
    }

    public int getRememberMeSeconds() {
        return rememberMeSeconds;
    }

    public void setRememberMeSeconds(int rememberMeSeconds) {
        this.rememberMeSeconds = rememberMeSeconds;
    }

    public String getSignOutUrl() {
        return signOutUrl;
    }

    public void setSignOutUrl(String signOutUrl) {
        this.signOutUrl = signOutUrl;
    }

    public String getSignUpUrl() {
        return signUpUrl;
    }

    public void setSignUpUrl(String signUpUrl) {
        this.signUpUrl = signUpUrl;
    }

    public LoginResponseType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginResponseType loginType) {
        this.loginType = loginType;
    }

    public String getSignInSuccessUrl() {
        return signInSuccessUrl;
    }

    public void setSignInSuccessUrl(String signInSuccessUrl) {
        this.signInSuccessUrl = signInSuccessUrl;
    }
}
