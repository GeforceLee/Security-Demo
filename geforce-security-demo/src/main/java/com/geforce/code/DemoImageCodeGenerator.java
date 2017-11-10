package com.geforce.code;

import com.geforce.security.core.validate.code.ImageCode;
import com.geforce.security.core.validate.code.ValidateCodeGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author geforce
 * @date 2017/11/10
 */
//@Component("imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator{
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public ImageCode generate(ServletWebRequest request) {
        logger.info("更高级的验证码");
        return null;
    }
}
