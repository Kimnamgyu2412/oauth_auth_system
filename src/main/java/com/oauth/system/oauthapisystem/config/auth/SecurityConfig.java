package com.oauth.system.oauthapisystem.config.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomAuthService customAuthService;

    public SecurityConfig(CustomAuthService customAuthService) {
        this.customAuthService = customAuthService;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider customAuthProvider() {
        return new CustomAuthProvider(customAuthService, passwordEncoder());
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();  // AuthenticationManager를 빈으로 등록
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(customAuthProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        // session management
        http.sessionManagement()
                .maximumSessions(10)
                .maxSessionsPreventsLogin(false)
                .expiredSessionStrategy(sessionInformationExpiredStrategy());

        // form login configuration
        http.formLogin()
                .loginPage("/login")
                .usernameParameter("userId")
                .passwordParameter("password")
                .loginProcessingUrl("/login/process")
                .successHandler(authenticationSuccessHandler())
                .failureHandler(authenticationFailureHandler());

        // authorize HTTP requests
//        http.authorizeRequests()
//                .antMatchers("/api/**").permitAll()  // API 요청은 OAuth2에서 처리하므로 Spring Security에서 제외
//                .antMatchers("/oauth/**").permitAll()  // API 요청은 OAuth2에서 처리하므로 Spring Security에서 제외
//                .mvcMatchers("/login/**").permitAll()
//                .mvcMatchers("/css/**").permitAll()
//                .mvcMatchers("/images/**").permitAll()
//                .mvcMatchers("/html/**").permitAll()
//                .mvcMatchers("/assets/**").permitAll()
//                .mvcMatchers("/**").hasAnyRole("ROLE_MEMBER")
//                .anyRequest().authenticated();  // 나머지는 기존 로그인 방식 적용

//        http.authorizeRequests()
//                .mvcMatchers("/public-api/**").permitAll()
//                .mvcMatchers("/css/**").permitAll()
//                .mvcMatchers("/images/**").permitAll()
//                .mvcMatchers("/html/**").permitAll()
//                .mvcMatchers("/assets/**").permitAll()
//                .mvcMatchers("/login/**").permitAll()
//                .mvcMatchers("/setting/**").hasAnyRole("ADMIN", "SETTING")
//                .mvcMatchers("/**").hasAnyRole("TEMPORARY", "MEMBER")
//                .anyRequest().authenticated();

        // logout configuration
        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");

        // exception handling
        http.exceptionHandling()
                .accessDeniedPage("/denied");

        // headers configuration
        http.headers()
                .frameOptions()
                .sameOrigin();
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new CustomSuccessHandler();
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new CustomFailureHandler();
    }

    @Bean
    public SessionInformationExpiredStrategy sessionInformationExpiredStrategy() {
        return new CustomSessionExpiredStrategy();
    }
}
