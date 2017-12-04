package com.geforce.security.browser.session;

import com.geforce.security.core.properties.SecurityProperties;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * 并发登录导致session失效时,默认的处理策略
 *
 * @author geforce
 * @date 2017/12/4
 */
public class GeforceExpiredSessionStrategy extends AbstractSessionStrategy implements SessionInformationExpiredStrategy {

    public GeforceExpiredSessionStrategy(SecurityProperties securityProperties) {
        super(securityProperties);
    }

    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {
        onSessionInvalid(event.getRequest(),event.getResponse());
    }

    @Override
    protected boolean isConcurrency(){
        return true;
    }

}
