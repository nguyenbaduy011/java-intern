package com.example.springbootdemo.user.dto.response;

import com.example.springbootdemo.user.enums.Role;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
    private String username;
    private String fullName;
    private String email;
    private String phone;
    private String avatar;
    private Role role;

}
