package com.geforce.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * @author geforce
 * @date 2017/11/9
 */

@ConfigurationProperties(prefix = "geforce.security")
public class SecurityProperties {

    private BrowserProperties browser = new BrowserProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }
}
