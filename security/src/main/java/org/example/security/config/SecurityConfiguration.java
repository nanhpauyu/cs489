package org.example.security.config;


import lombok.RequiredArgsConstructor;
import org.example.security.user.Role;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//@Configurable
//@EnableWebSecurity
//@EnableMethodSecurity
//public class SecurityConfiguration {
//

/// /    @Bean
/// /    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
/// /        http.csrf(CsrfConfigurer::disable)
/// /                .authorizeHttpRequests(
/// /                        authorizeRequests -> authorizeRequests
/// /                                .requestMatchers("/api/v1/auth/*").permitAll()
/// ///                                .requestMatchers("/api/v1/auth/authenticate").permitAll()
/// /                                .anyRequest()
/// /                                .authenticated()
/// /                );
/// /        return http.build();
/// /    }
//}

@EnableWebSecurity
@Configuration
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtFilter jwtFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(CsrfConfigurer::disable)
                .authorizeHttpRequests(
                        req -> req.requestMatchers("/api/v1/auth/*").permitAll()
                                .requestMatchers("/api/v1/management/**").hasAnyAuthority(Role.ADMIN.name(),
                                        Role.MEMBER.name())
                                .requestMatchers("/api/v1/admin/**").hasRole(Role.ADMIN.name())
                                .anyRequest()
                                .authenticated()
                )
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .authenticationProvider(authenticationProvider)
                .sessionManagement(
                        sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .build();
    }
}

