package com.oauth.system.oauthapisystem.config;

import com.oauth.system.oauthapisystem.interceptor.OAuth2Interceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 스프링 webmvc 설정 클래스
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {


    private final OAuth2Interceptor oAuth2Interceptor;

    public WebMvcConfig(OAuth2Interceptor oAuth2Interceptor) {
        this.oAuth2Interceptor = oAuth2Interceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(oAuth2Interceptor)
                .addPathPatterns("/api/**"); // 해당 API 경로에만 인터셉터 적용

    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
//        resolvers.add(new NotificationSubjectHandlerMethodArgumentResolver());
//        resolvers.add(new NotificationStatusHandlerMethodArgumentResolver(amazonSns));
//        resolvers.add(new NotificationMessageHandlerMethodArgumentResolver());
    }
}
