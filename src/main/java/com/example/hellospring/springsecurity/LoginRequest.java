package com.example.hellospring.springsecurity;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
