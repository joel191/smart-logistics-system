package com.joel.logistics.controller;

import com.joel.logistics.dto.LoginRequest;
import com.joel.logistics.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public String login(@RequestBody @Valid LoginRequest request) {
        return authService.login(request);
    }
}
