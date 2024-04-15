package com.strelnikov.accountservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class ResourceServerConfig {

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .securityMatcher("/users/**")
//                .authorizeHttpRequests(authorize -> authorize
//                        .anyRequest()
//                        .hasAuthority("SCOPE_server"))
//                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));
//
//        return http.build();
//    }
}
