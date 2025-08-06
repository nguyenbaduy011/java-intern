package com.example.springbootdemo.user.controller;

import com.example.springbootdemo.user.dto.request.ChangePasswordRequest;
import com.example.springbootdemo.user.dto.request.CreateUserRequest;
import com.example.springbootdemo.user.dto.request.LoginRequest;
import com.example.springbootdemo.user.dto.response.UserResponse;
import com.example.springbootdemo.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody LoginRequest loginRequest, Model model) {
        UserResponse response = userService.login(loginRequest);
        model.addAttribute("message", "Login successful for user: " + response.getUsername());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody CreateUserRequest createUserRequest) {
        UserResponse response = userService.createUser(createUserRequest);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{username}")
    public ResponseEntity<Void> deleteUser(@PathVariable String username) {
        userService.deleteUser(username);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/changepassword")
    public ResponseEntity<Void> changePassword(@RequestBody ChangePasswordRequest changePasswordRequest) {
        userService.changePassword(changePasswordRequest);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserResponse>> findAllUsers() {
        List<UserResponse> users = userService.findAllUsers();
        return ResponseEntity.ok(users);
    }
}
