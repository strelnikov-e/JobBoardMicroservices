package com.strelnikov.gateway.config;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    RouteLocator gateway(RouteLocatorBuilder locatorBuilder) {
        var apiPrefix = "/api/";
        var apiVerion = "/v1";
        return locatorBuilder
                .routes()
                // job-service
                .route("job-service",rs -> rs
                        .path(apiPrefix + "jobs/**")
                        .filters(f -> f
                                .tokenRelay()
                                .removeRequestHeader("Cookie")
                                .rewritePath(apiPrefix + "(?<segment>.*)",  apiVerion + "/$\\{segment}")
                        )
                        .uri("lb://job-service"))
                // user-service
                .route("user-service",rs -> rs
                        .path(apiPrefix + "users/**")
                        .filters(f -> f
                                .tokenRelay()
                                .removeRequestHeader("Cookie")
                                .rewritePath(apiPrefix + "(?<segment>.*)",  apiVerion + "/$\\{segment}")
                        )
                        .uri("lb://user-service"))
                .route("application-service",rs -> rs
                        .path(apiPrefix + "applications/**")
                        .filters(f -> f
                                .tokenRelay()
                                .removeRequestHeader("Cookie")
                                .rewritePath(apiPrefix + "(?<segment>.*)",  apiVerion + "/$\\{segment}")
                        )
                        .uri("lb://application-service"))
                .build();
    }

}
//
//    @Autowired
//    private TokenRelayGatewayFilterFactory filterFactory;
//
//    @Bean
//    RouteLocator gateway(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("jobs", rs -> rs
//                        .path("/api/jobs/**")
//                        .filters(f -> f.filters(filterFactory.apply())
//                                .removeRequestHeader("Cookie"))
//                        .uri("lb://job-service"))
//                .route(rs -> rs
//                        .path("/api/users")
//                        .filters(GatewayFilterSpec::tokenRelay)
//                        .uri("http://127.0.0.1:8081/api/users"))
//                .route(rs -> rs
//                        .path("/api/applications")
//                        .filters(GatewayFilterSpec::tokenRelay)
//                        .uri("http://127.0.0.1:8083/api/applications"))
//                .build();
//    }
//}
