package com.oauth.system.oauthapisystem.config.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 스프링 시큐리티 인증실패 핸들러
 */
@Slf4j
public class CustomFailureHandler implements AuthenticationFailureHandler {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {

        response.setCharacterEncoding("utf-8");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.UNAUTHORIZED.value());

        String message = "아이디,패스워드를 확인해주세요";

        // 인증 실패 예외 처리
        if (exception instanceof BadCredentialsException) {
            log.warn("Bad credentials: {}", exception.getMessage());
            objectMapper.writeValue(response.getWriter(), message);
        } else if (exception instanceof DisabledException) {
            log.warn("Account disabled: {}", exception.getMessage());
            objectMapper.writeValue(response.getWriter(), exception.getMessage());
        } else {
            log.error("Authentication failed: {}", exception.getMessage());
            objectMapper.writeValue(response.getWriter(), message);
        }
    }
}
