package com.example.demovalidation.service;

import com.example.demovalidation.dto.UserDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class UserService {

    public void validateUser(@Valid UserDTO userDTO) {
        // logic giả định
        System.out.println("User is valid in service layer");
    }
}
