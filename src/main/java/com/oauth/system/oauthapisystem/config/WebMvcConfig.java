package com.oauth.system.oauthapisystem.config;

import org.springframework.cloud.aws.messaging.endpoint.NotificationMessageHandlerMethodArgumentResolver;
import org.springframework.context.annotation.Bean;
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

//    @Autowired
//    private SearchFilterService searchFilterService;
//    @Autowired
//    private AmazonSNS amazonSns;


    @Bean
    public NotificationMessageHandlerMethodArgumentResolver notificationMessageHandlerMethodArgumentResolver() {
        return new NotificationMessageHandlerMethodArgumentResolver();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoggingInterceptor(logService))
//                .addPathPatterns("/api/v1/**");
//                .addPathPatterns(
//                        //"/customers"
//                        "/customers/attendees"
//                        , "/customers/leads"
//                    , "/customers/chance/exhibition"
//                    , "/customers/chance/kanban"
//                );
//
//        registry.addInterceptor(new AuthInterceptor())
//                .addPathPatterns("/customers/**"
//                        , "/marketing/**"
//                        , "/homepage/**"
//                        , "/setting/**"
//                        , "/calendar/**"
//                        , "/preview/**"
//                        , "/generate-pdf/**"
//                        , "/profile/**"
//                    , "/companies/**"
//                );
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
//        resolvers.add(new NotificationSubjectHandlerMethodArgumentResolver());
//        resolvers.add(new NotificationStatusHandlerMethodArgumentResolver(amazonSns));
//        resolvers.add(new NotificationMessageHandlerMethodArgumentResolver());
    }
}
