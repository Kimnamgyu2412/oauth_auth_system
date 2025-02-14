package com.oauth.system.oauthapisystem.config.auth;


import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * 스프링시큐리티 커스텀 인증 프로바이더
 * 아이디,패스워드롤 이용해 유효한 사용자인 경우 UsernamePasswordAuthenticationToken 을 스프링시큐리티에 등록한다.
 */
@Slf4j
public class CustomAuthProvider implements AuthenticationProvider {

    private final CustomAuthService customAuthService;
    private final PasswordEncoder passwordEncoder;

    public CustomAuthProvider(CustomAuthService customAuthService, PasswordEncoder passwordEncoder) {
        this.customAuthService = customAuthService;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

        String userId = authentication.getName();
        String userPwd = (String) authentication.getCredentials();

        UserDetails userDetails = customAuthService.loadUserByUsername(userId);


        log.info("hashed password={}", passwordEncoder.encode(userPwd));
//        if (!passwordEncoder.matches(userPwd, userDetails.getPassword())) {
//            throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
//        } else if (!userDetails.isEnabled()) {
//            throw new DisabledException("삭제된 계정입니다.");
//        }
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                userDetails, userPwd, userDetails.getAuthorities());

        authToken.setDetails(userDetails);
        authToken.eraseCredentials();

        return authToken;


    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
