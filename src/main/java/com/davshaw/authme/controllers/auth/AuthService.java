package com.davshaw.authme.controllers.auth;

import org.springframework.stereotype.Service;

import com.davshaw.authme.roles.User;
import com.davshaw.authme.jwt.JwtService;
import com.davshaw.authme.repositories.UserRepository;
import com.davshaw.authme.roles.Roles;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
        .user(request.getUser())
        .password(request.getPassword())
        .email(request.getEmail())
        .firstname(request.getFirstname())
        .lastname(request.getLastname())
        .country(request.getCountry())
        .role(Roles.USER)
        .build();

        userRepository.save(user);

        AuthResponse response = AuthResponse.builder()
        .token(jwtService.getToken(user))
        .build();
        return response;
    }

    public AuthResponse login(LoginRequest request) {
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }

}
