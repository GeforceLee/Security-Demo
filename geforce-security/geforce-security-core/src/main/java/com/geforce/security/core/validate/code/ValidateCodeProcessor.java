package com.geforce.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.ServletRequest;

/**
 * @author geforce
 * @date 2017/11/13
 */
public interface ValidateCodeProcessor {

    String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";


    /**
     * 创建校验码
     * @param request
     * @throws Exception
     */
    void create(ServletWebRequest request) throws Exception;


    /**
     * 校验验证码
     * @param request
     */
    void validate(ServletWebRequest request);
}
