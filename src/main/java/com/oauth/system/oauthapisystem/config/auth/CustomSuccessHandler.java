package com.oauth.system.oauthapisystem.config.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 스프링시큐리티 인증 성공 처리 핸들러
 */
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

    private final ObjectMapper objectMapper = new ObjectMapper();
//    @Autowired
//    private LogService logService;
//    @Autowired
//    private MemberService memberService;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        String ip = request.getHeader("X-FORWARDED-FOR");
        if (ip == null)
            ip = request.getRemoteAddr();

//        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
//        logService.login(user.getUsername(), ip);
//
//        Member member = memberService.findUser(user.getUsername());
//        request.getSession().setAttribute("memberName", member.getName());

        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.sendRedirect("/main");
//        objectMapper.writeValue(response.getWriter(), user);
    }


}
