//package com.example.clubspring;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll() // Разрешить Swagger без авторизации
//                        .anyRequest().authenticated() // Остальные запросы требуют логина
//                )
//                .formLogin(); // Включить страницу логина
//
//        return http.build();
//    }
//}
