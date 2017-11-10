package com.geforce.security.core.authentication.sms;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * @author geforce
 * @date 2017/11/10
 */
public class SmsCodeAuthenticationToken extends UsernamePasswordAuthenticationToken {
    public SmsCodeAuthenticationToken(Object principal) {
        super(principal, null);
    }
}
