package com.example.projectrserver.global.config;

import com.example.projectrserver.global.security.jwt.JwtTokenProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
public class SecurityConfig {
    private final JwtTokenProvider jwtTokenProvider;

    private final ObjectMapper objectMapper;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf().disable()
                .formLogin().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http
                .authorizeHttpRequests()

                .requestMatchers(HttpMethod.POST, "/v1/accounts").permitAll()
                .requestMatchers(HttpMethod.POST, "/v1/accounts/sign").permitAll()
                .requestMatchers(HttpMethod.GET, "/v1/accounts").authenticated()

                .requestMatchers(HttpMethod.POST, "/v1/routines/like/{id}").authenticated()
                .requestMatchers(HttpMethod.DELETE, "/v1/routines/like/{id}").authenticated()

                .requestMatchers(HttpMethod.POST, "/v1/routines").authenticated()
                .requestMatchers(HttpMethod.GET, "/v1/routines").authenticated()
                .requestMatchers(HttpMethod.GET, "/v1/routines{id}").authenticated()

                .anyRequest().authenticated()
                .and()
                .apply(new FilterConfig(objectMapper, jwtTokenProvider));

        return http.build();
    }
}