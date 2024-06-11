package com.davshaw.authme.configs;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.Customizer;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    // Config for public endpoints
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(
            csrf -> 
            csrf.disable());

        http.authorizeHttpRequests(
            authRequest ->
            authRequest.requestMatchers("/auth/**").permitAll());

        http.authorizeHttpRequests(
            authRequest ->
            authRequest.anyRequest().authenticated());

        http.formLogin(Customizer.withDefaults());

        return http.build();

    }
    // Config for protected endpoints
}
