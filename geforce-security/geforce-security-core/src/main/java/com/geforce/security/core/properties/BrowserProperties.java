package com.geforce.security.core.properties;

/**
 * @author geforce
 * @date 2017/11/9
 */
public class BrowserProperties {
    private String loginPage = "/geforce-signIn.html";

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }


    private LoginType loginType = LoginType.JSON;

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }
}
