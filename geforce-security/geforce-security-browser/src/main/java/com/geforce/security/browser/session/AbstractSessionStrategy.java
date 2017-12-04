package com.geforce.security.browser.session;

import com.geforce.security.core.properties.SecurityProperties;
import com.geforce.security.core.support.SimpleResponse;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 抽象的session失效处理器
 *
 * @author geforce
 * @date 2017/12/4
 */
public class AbstractSessionStrategy {
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 跳转的url
     */
    private String destinationUrl;

    /**
     * 系统配置信息
     */
    private SecurityProperties securityProperties;

    /**
     * 重定向策略
     */
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    /**
     * 跳转前是否创建新的session
     */
    private boolean createNewSession = true;


    private ObjectMapper objectMapper = new ObjectMapper();


    public AbstractSessionStrategy(SecurityProperties securityProperties) {
        String invalidSessionUrl = securityProperties.getBrowser().getSession().getSessionInvalidUrl();
        Assert.isTrue(UrlUtils.isValidRedirectUrl(invalidSessionUrl), "url must start with'/' or with 'http(s)'");
        Assert.isTrue(StringUtils.endsWithIgnoreCase(invalidSessionUrl, ".html"), "url must end with html");
        this.destinationUrl = invalidSessionUrl;
        this.securityProperties = securityProperties;
    }

    protected void onSessionInvalid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info("session 失效");

        if (createNewSession) {
            request.getSession();
        }

        String sourceUrl = request.getRequestURI();
        String targetUrl;
        if (StringUtils.endsWithIgnoreCase(sourceUrl, ".html")) {
            if (StringUtils.equals(sourceUrl,securityProperties.getBrowser().getSignInPage())
                    || StringUtils.equals(sourceUrl,securityProperties.getBrowser().getSignOutUrl())){
                targetUrl = sourceUrl;
            } else {
                targetUrl = destinationUrl;
            }

            logger.info("跳转到:" + targetUrl);
            redirectStrategy.sendRedirect(request,response,targetUrl);
        } else {
            Object result = buildResponseContent(request);
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(result));
        }
    }

    /**
     *
     * @param request
     * @return
     */
    protected Object buildResponseContent(HttpServletRequest request) {
        String message = "Session已失效";
        if (isConcurrency()){
            message = message + ", 有可能是并发登录导致的";
        }
        return new SimpleResponse(message);
    }

    /**
     * session失效是否是并发导致的
     * @return
     */
    protected boolean isConcurrency() {
        return false;
    }

    public void setCreateNewSession(boolean createNewSession) {
        this.createNewSession = createNewSession;
    }
}
