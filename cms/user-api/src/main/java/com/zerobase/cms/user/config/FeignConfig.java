package com.zerobase.cms.user.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;

@Configuration
public class FeignConfig {

    @Value(value = "${mailgun.key}")
    private String mailgunKey;


    @Qualifier(value = "mailgun")
    @Bean
    public BasicAuthenticationInterceptor basicAuthenticationInterceptor(){
        //TODO cd~~ 수정
        return new BasicAuthenticationInterceptor("api",mailgunKey);
    }

}
