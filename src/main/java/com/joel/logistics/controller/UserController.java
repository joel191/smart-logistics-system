package com.joel.logistics.controller;

import com.joel.logistics.dto.CreateUserRequest;
import com.joel.logistics.service.UserService;
import com.joel.logistics.user.User;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody @Valid CreateUserRequest request) {
        return userService.createUser(request);
    }
}
