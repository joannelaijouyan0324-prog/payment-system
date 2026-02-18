package com.joanne.payment.controller;

import com.joanne.payment.dto.CreateUserRequest;
import com.joanne.payment.dto.LoginRequest;
import com.joanne.payment.dto.LoginResponse;
import com.joanne.payment.dto.UserResponse;
import com.joanne.payment.entity.User;
import com.joanne.payment.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserResponse createUser(@RequestBody CreateUserRequest request) {

        User savedUser = userService.createUser(request.getUsername(), request.getEmail(), request.getPassword());

        UserResponse userResponse = new UserResponse();

        userResponse.setId(savedUser.getId());
        userResponse.setUsername(savedUser.getUsername());
        userResponse.setEmail(savedUser.getEmail());
        userResponse.setCreatedAt(savedUser.getCreatedAt());
        userResponse.setStatus(savedUser.getStatus());

        return userResponse;
    }
}
