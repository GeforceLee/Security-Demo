package com.geforce.security.browser.session;

import com.geforce.security.core.properties.SecurityProperties;
import org.springframework.security.web.session.InvalidSessionStrategy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 默认的session失效处理策略
 *
 * @author geforce
 * @date 2017/12/4
 */
public class GeforceInvalidSessionStrategy extends AbstractSessionStrategy implements InvalidSessionStrategy {
    public GeforceInvalidSessionStrategy(SecurityProperties securityProperties) {
        super(securityProperties);
    }

    @Override
    public void onInvalidSessionDetected(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        onSessionInvalid(request,response);
    }
}
