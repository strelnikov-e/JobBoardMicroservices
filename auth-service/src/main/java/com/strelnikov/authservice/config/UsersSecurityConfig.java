package com.strelnikov.authservice.config;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import javax.sql.DataSource;
import java.util.Map;

// Configures persistent users
@Configuration
public class UsersSecurityConfig {

    @Bean
    JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    ApplicationRunner usersRunner(UserDetailsManager userDetailsManager) {
        return args -> {
            var builder = User.builder().roles("USER");
            var users = Map.of(
                    "user", "{bcrypt}$2a$10$KjtoYpfPX3h..mhTH4YfLePC/Udf3xJv6EuuIpfIjpHbwtpQJmiMm",
                    "admin", "{bcrypt}$2a$10$6sFdm/jr8F3IbkTFOPIWsOcez1M/Z/ZxsQ6RxG65y1Ivfwya.ahey");
            users.forEach((username, password) -> {
                if (!userDetailsManager.userExists(username)) {
                    var user = builder
                            .username(username)
                            .password(password)
                            .build();
                    userDetailsManager.createUser(user);
                }
            });
        };
    }
}
