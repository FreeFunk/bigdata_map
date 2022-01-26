package com.edgedo.common.shiro;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtRsaSecKey {
    @Value("${JwtRsaSecKey.rsaPublicKey}")
    private String rsaPublicKey;
    @Value("${JwtRsaSecKey.rsaPrivateKey}")
    private String rsaPrivateKey;
    @Value("${JwtRsaSecKey.jwtSecretkey}")
    private String jwtSecretkey;

    public String getRsaPublicKey() {
        return rsaPublicKey;
    }

    public void setRsaPublicKey(String rsaPublicKey) {
        this.rsaPublicKey = rsaPublicKey;
    }

    public String getRsaPrivateKey() {
        return rsaPrivateKey;
    }

    public void setRsaPrivateKey(String rsaPrivateKey) {
        this.rsaPrivateKey = rsaPrivateKey;
    }

    public String getJwtSecretkey() {
        return jwtSecretkey;
    }

    public void setJwtSecretkey(String jwtSecretkey) {
        this.jwtSecretkey = jwtSecretkey;
    }
}
