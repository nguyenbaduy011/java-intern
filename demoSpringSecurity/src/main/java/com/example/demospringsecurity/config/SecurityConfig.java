package com.example.demospringsecurity.config;

import com.example.demospringsecurity.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomUserDetailsService userDetailsService;

    public SecurityConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    // Cấu hình Security Filter Chain để xử lý các yêu cầu HTTP
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/public").permitAll() // Cho phép truy cập không cần xác thực
                        .requestMatchers("/admin").hasRole("ADMIN") // Chỉ ADMIN truy cập được /admin
                        .requestMatchers("/user").hasRole("USER") // Chỉ USER truy cập được /user
                        .anyRequest().authenticated() // Các yêu cầu khác cần xác thực
                )
                .formLogin(form -> form
                        .loginPage("/login") // Trang đăng nhập tùy chỉnh
                        .loginProcessingUrl("/login") // URL xử lý form đăng nhập
                        .defaultSuccessUrl("/home", true) // Chuyển hướng sau khi đăng nhập thành công
                        .failureUrl("/login?error=true") // Chuyển hướng khi đăng nhập thất bại
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout") // Chuyển hướng sau khi đăng xuất
                        .permitAll()
                );
        return http.build();
    }

    // Cấu hình Authentication Manager để xử lý xác thực
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}