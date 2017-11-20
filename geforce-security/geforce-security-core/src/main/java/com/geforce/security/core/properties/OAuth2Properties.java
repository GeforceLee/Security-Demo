package com.geforce.security.core.properties;

/**
 * @author geforce
 * @date 2017/11/20
 */
public class OAuth2Properties {

    /**
     * 使用jwt时为token签名的密钥
     */
    private String jwtSigningKey = "geforce";

    /**
     * 客户端配置
     */
    private OAuth2ClientProperties[] clients = {};

    public String getJwtSigningKey() {
        return jwtSigningKey;
    }

    public void setJwtSigningKey(String jwtSigningKey) {
        this.jwtSigningKey = jwtSigningKey;
    }

    public OAuth2ClientProperties[] getClients() {
        return clients;
    }

    public void setClients(OAuth2ClientProperties[] clients) {
        this.clients = clients;
    }
}
