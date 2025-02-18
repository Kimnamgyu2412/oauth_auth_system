package com.oauth.system.oauthapisystem.config.oauth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
public class TokenStoreConfig {

    @Bean
    public TokenStore tokenStore() {
        return new InMemoryTokenStore(); // 메모리 기반 토큰 저장소
    }
}
