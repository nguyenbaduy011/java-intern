package com.example.demospringsecurity.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/home")
    @ResponseBody
    public String home(Authentication authentication) {
        return "Welcome, " + authentication.getName() + "!";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String admin() {
        return "Admin Page";
    }

    @GetMapping("/user")
    @ResponseBody
    public String user() {
        return "User Page";
    }

    @GetMapping("/public")
    @ResponseBody
    public String publicPage() {
        return "Public Page";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}