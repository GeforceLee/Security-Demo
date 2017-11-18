package com.geforce.security;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;

/**
 * @author geforce
 * @date 2017/11/18
 */
public class DemoConnectionSignUp implements ConnectionSignUp {
    @Override
    public String execute(Connection<?> connection) {
        // 根据connection信息生成Demo项目用户并返回用户id;
        return RandomStringUtils.randomNumeric(6);
    }
}
