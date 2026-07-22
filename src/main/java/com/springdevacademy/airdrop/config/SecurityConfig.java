package com.springdevacademy.airdrop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        // Allow public access to homepage, static assets, and downloads
                        .requestMatchers("/", "/css/**", "/js/**", "/images/**").permitAll()

                        // Restrict /admin routes to logged-in users only
                        .requestMatchers("/admin/**").authenticated()

                        // Any other request requires authentication
                        .anyRequest().authenticated()
                )
                // Enable default Spring Security form login
                .formLogin(form -> form
                        .defaultSuccessUrl("/admin/add", true)
                        .permitAll()
                )
                // Enable logout redirecting to home page
                .logout(logout -> logout
                        .logoutSuccessUrl("/")
                        .permitAll()
                );

        return http.build();
    }
}