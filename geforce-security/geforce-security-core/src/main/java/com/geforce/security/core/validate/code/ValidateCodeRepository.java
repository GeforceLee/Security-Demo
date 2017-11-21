package com.geforce.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 校验码存取器
 * @author geforce
 * @date 2017/11/21
 */
public interface ValidateCodeRepository {

    /**
     * 保存验证码
     * @param request
     * @param code
     * @param validateCodeType
     */
    void save(ServletWebRequest request,ValidateCode code,ValidateCodeType validateCodeType);

    /**
     * 获取验证码
     * @param request
     * @param validateCodeType
     * @return
     */
    ValidateCode get(ServletWebRequest request,ValidateCodeType validateCodeType);


    /**
     * 一处验证码
     * @param request
     * @param validateCodeType
     */
    void remove(ServletWebRequest request,ValidateCodeType validateCodeType);


}
