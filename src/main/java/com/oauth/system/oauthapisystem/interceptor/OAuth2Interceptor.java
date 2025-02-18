package com.oauth.system.oauthapisystem.interceptor;

import com.oauth.system.oauthapisystem.config.oauth.dto.ClientContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class OAuth2Interceptor implements HandlerInterceptor {

    private final TokenStore tokenStore;

    public OAuth2Interceptor(TokenStore tokenStore) {
        this.tokenStore = tokenStore;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // "Authorization" 헤더에서 토큰 값을 추출
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String accessToken = authorizationHeader.replace("Bearer ", "");
            log.info("accessToken      :    " +accessToken);

            // 액세스 토큰을 통해 클라이언트 정보 얻기
            OAuth2Authentication authentication = tokenStore.readAuthentication(accessToken);
            if (authentication != null) {
                String clientId = authentication.getName();  // 클라이언트 ID
                ClientContext.setClientId(clientId);
                log.info("clientId      :    " +clientId);
                return true;
            } else {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);  // 401 Unauthorized
                response.getWriter().write("Invalid or expired token");
                return false;  // 요청을 처리하지 않음
            }
        }

        return false;
    }

}
