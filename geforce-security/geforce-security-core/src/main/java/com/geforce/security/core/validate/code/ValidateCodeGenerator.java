package com.geforce.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author geforce
 * @date 2017/11/10
 */
public interface ValidateCodeGenerator {
    ImageCode generate(ServletWebRequest request);
}
