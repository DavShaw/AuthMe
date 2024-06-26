package com.davshaw.authme.controllers.auth;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class ServiceAuthController {

    @PostMapping(value = "test")
    public String test() {
        return "Test from protected endpoint";
    }

}
