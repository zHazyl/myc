package com.tnh.messageservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
    @Bean
    MapReactiveUserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("hanh")
                .password("1")
                .roles("USER")
                .build();
        return new MapReactiveUserDetailsService(user);
    }

    @Bean
    SecurityWebFilterChain filterChain(ServerHttpSecurity http) {
        http.authorizeExchange(exchanges -> exchanges
                .anyExchange().authenticated()
        )
        .httpBasic(Customizer.withDefaults())
        .formLogin(Customizer.withDefaults());
        return http.build();
    }
}