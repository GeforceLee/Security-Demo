package com.geforce.security.core.validate.code.sms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author geforce
 * @date 2017/11/10
 */
public class DefaultSmsCodeSender implements SmsCodeSender {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public void send(String mobile, String code) {
        logger.info("向手机"+mobile+"发送验证码"+code);
    }



}
