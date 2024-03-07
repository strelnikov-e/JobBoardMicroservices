package com.strelnikov.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    RouteLocator gateway(RouteLocatorBuilder rlb) {
        return rlb
                .routes()
                .route(rs -> rs
                        .path("/hello")
                        .filters(GatewayFilterSpec::tokenRelay)
                        .uri("http://localhost:8090"))
                .route(rs -> rs
                        .path("/api/users")
                        .filters(GatewayFilterSpec::tokenRelay)
                        .uri("http://127.0.0.1:8081/api/users"))
                .route(rs -> rs
                        .path("/api/jobs")
                        .filters(GatewayFilterSpec::tokenRelay)
                        .uri("http://127.0.0.1:8082/api/jobs"))
                .route(rs -> rs
                        .path("/api/applications")
                        .filters(GatewayFilterSpec::tokenRelay)
                        .uri("http://127.0.0.1:8083/api/applications"))
                .build();
    }
}
