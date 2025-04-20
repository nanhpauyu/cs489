package org.example.lab9.config;

import lombok.RequiredArgsConstructor;
import org.example.lab9.model.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
@EnableMethodSecurity
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        System.out.println("securityFilterChain");
        SecurityFilterChain securityFilterChain =http.csrf(CsrfConfigurer::disable)
                        .authorizeHttpRequests(
                                req -> req.requestMatchers("/api/v1/auth/register").permitAll()
                                        .anyRequest()
                                        .authenticated()
                        )
                        .build();
        System.out.println(securityFilterChain.getFilters());
        return securityFilterChain;
    }
}

