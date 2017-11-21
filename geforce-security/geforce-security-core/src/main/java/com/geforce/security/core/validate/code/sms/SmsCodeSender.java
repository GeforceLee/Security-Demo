package com.geforce.security.core.validate.code.sms;

/**
 * @author geforce
 * @date 2017/11/10
 */
public interface SmsCodeSender {

    /**
     *
     * @param mobile
     * @param code
     */
    void send(String mobile,String code);

}
