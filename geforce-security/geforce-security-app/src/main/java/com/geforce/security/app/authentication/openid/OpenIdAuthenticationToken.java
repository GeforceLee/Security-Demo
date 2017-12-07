package com.geforce.security.app.authentication.openid;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author geforce
 * @date 2017/12/5
 */
public class OpenIdAuthenticationToken extends AbstractAuthenticationToken{

    private final Object principal;
    private String providerId;


    public OpenIdAuthenticationToken(String openid, String providerId) {
        super(null);
        this.principal = openid;
        this.providerId = providerId;
        setAuthenticated(false);
    }

    public OpenIdAuthenticationToken(Object principal, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        super.setAuthenticated(true);
    }



    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }

    public String getProviderId() {
        return providerId;
    }

    @Override
    public void setAuthenticated(boolean authenticated) {
        if (authenticated) {
            throw new IllegalArgumentException("Cannot set this token to trusted - " +
                    "use constructor which takes a GrantedAuthority list instead");
        }
        super.setAuthenticated(false);
    }
}
