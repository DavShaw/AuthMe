package com.davshaw.authme.controller.auth;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class authService {

    public AuthResponse register(RegisterRequest request) {
        throw new UnsupportedOperationException("Unimplemented method 'register'");
    }

    public AuthResponse login(LoginRequest request) {
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }

}
