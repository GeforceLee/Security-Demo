package com.geforce.security.app.authentication.openid;

import com.geforce.security.core.properties.SecurityConstants;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * openid
 *
 * @author geforce
 * @date 2017/12/5
 */
public class OpenIdAuthenticationFilter extends AbstractAuthenticationProcessingFilter{

    private String openIdParameter = SecurityConstants.DEFAULT_PARAMETER_NAME_OPENID;
    private String providerIdParameter = SecurityConstants.DEFAULT_PARAMETER_NAME_PROVIDERID;
    private boolean postOnly = true;


    protected OpenIdAuthenticationFilter() {
        super(new AntPathRequestMatcher(SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_OPENID,"POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        if (postOnly && !request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }

        String openid = obtainOpenId(request);
        String providerId = obtainProviderId(request);

        if (openid == null) {
            openid = "";
        }

        if (providerId == null) {
            providerId = "";
        }

        openid = openid.trim();
        providerId = providerId.trim();

        OpenIdAuthenticationToken authRequest = new OpenIdAuthenticationToken(openid,providerId);

        setDetails(request, authRequest);

        return this.getAuthenticationManager().authenticate(authRequest);
    }




    /**
     * 获取提供商id
     * @param request
     * @return
     */
    private String obtainProviderId(HttpServletRequest request) {
        return request.getParameter(providerIdParameter);
    }


    /**
     * 获取openId
     * @param request
     * @return
     */
    private String obtainOpenId(HttpServletRequest request) {
        return request.getParameter(openIdParameter);
    }


    /**
     * Provided so that subclasses may configure what is put into
     * the authentication request's details property
     *
     * @param request
     * @param authRequest
     */
    private void setDetails(HttpServletRequest request, OpenIdAuthenticationToken authRequest) {
        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
    }

    public String getOpenIdParameter() {
        return openIdParameter;
    }

    public void setOpenIdParameter(String openIdParameter) {
        this.openIdParameter = openIdParameter;
    }

    public String getProviderIdParameter() {
        return providerIdParameter;
    }

    public void setProviderIdParameter(String providerIdParameter) {
        this.providerIdParameter = providerIdParameter;
    }

    public boolean isPostOnly() {
        return postOnly;
    }

    public void setPostOnly(boolean postOnly) {
        this.postOnly = postOnly;
    }
}
