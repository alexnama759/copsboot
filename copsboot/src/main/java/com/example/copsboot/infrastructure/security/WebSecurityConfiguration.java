package com.example.copsboot.infrastructure.security;

import com.c4_soft.springaddons.security.oidc.starter.synchronised.resourceserver.ResourceServerExpressionInterceptUrlRegistryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
public class WebSecurityConfiguration {

    @Bean
    ResourceServerExpressionInterceptUrlRegistryPostProcessor authorizePostProcessor() { //<.>
        return registry -> registry.requestMatchers(HttpMethod.OPTIONS, "/api/**").permitAll()
                .requestMatchers("/api/**").authenticated()
                .anyRequest().authenticated();
    }
}


