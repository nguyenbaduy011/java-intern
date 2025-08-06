package com.example.demospringsecurity.service;


import com.example.demospringsecurity.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private List<User> users = new ArrayList<>();

    public CustomUserDetailsService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    // Khởi tạo dữ liệu người dùng giả lập (in-memory) khi ứng dụng khởi động
    @PostConstruct
    public void init() {
        users.add(new User("admin", passwordEncoder.encode("admin123"), "ROLE_ADMIN"));
        users.add(new User("user", passwordEncoder.encode("user123"), "ROLE_USER"));
    }

    // Tải thông tin người dùng từ danh sách giả lập dựa trên username
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = users.stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        // Tạo UserDetails từ thông tin người dùng
        UserBuilder builder = org.springframework.security.core.userdetails.User.builder();
        return builder
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(new SimpleGrantedAuthority(user.getRole()))
                .build();
    }
}
