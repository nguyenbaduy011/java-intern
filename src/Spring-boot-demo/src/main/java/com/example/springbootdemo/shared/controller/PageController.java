package com.example.springbootdemo.shared.controller;

import com.example.springbootdemo.user.dto.request.LoginRequest;
import com.example.springbootdemo.user.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
    private final UserService userService;

    public PageController(UserService userService) {
        this.userService = userService;
    }

    @Value("${app.message}")
    private String message;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("message", message);
        return "loginSuccess";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam String username,
                              @RequestParam String password, Model model) {
        LoginRequest loginRequest = new LoginRequest(username, password);
        try {
            userService.login(loginRequest);
            model.addAttribute("message", "Login successful for user: " + username);
            return "loginSuccess";
        } catch (Exception e) {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

}