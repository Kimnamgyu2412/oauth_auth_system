package com.oauth.system.oauthapisystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
//@EnableWebSecurity
public class OauthApiSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(OauthApiSystemApplication.class, args);
    }

}
