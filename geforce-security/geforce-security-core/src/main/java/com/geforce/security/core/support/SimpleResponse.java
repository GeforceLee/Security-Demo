package com.geforce.security.core.support;

/**
 * 简单响应的封装类
 *
 * @author geforce
 * @date 2017/11/9
 */
public class SimpleResponse {
    private Object content;

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public SimpleResponse(Object content) {
        this.content = content;
    }
}
