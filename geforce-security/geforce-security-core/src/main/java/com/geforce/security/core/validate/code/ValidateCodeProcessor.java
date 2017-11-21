package com.geforce.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.ServletRequest;

/**
 * 校验码处理器,封装不同校验码的处理逻辑
 * @author geforce
 * @date 2017/11/13
 */
public interface ValidateCodeProcessor {


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
