package com.geforce.security.core.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
 * @author geforce
 * @date 2017/11/9
 */
public class ValidateCodeException extends AuthenticationException {


    public ValidateCodeException(String msg) {
        super(msg);
    }
}
