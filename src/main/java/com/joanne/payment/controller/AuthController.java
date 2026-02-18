package com.joanne.payment.controller;

import com.joanne.payment.dto.LoginRequest;
import com.joanne.payment.dto.LoginResponse;
import com.joanne.payment.entity.User;
import com.joanne.payment.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public LoginResponse loginUser(@RequestBody LoginRequest request) {

        User loginUser = userService.login(request.getEmail(), request.getPassword());

        LoginResponse loginResponse = new LoginResponse();

        loginResponse.setUsername(loginUser.getUsername());
        loginResponse.setEmail(loginUser.getEmail());
        loginResponse.setStatus(loginUser.getStatus());
        loginResponse.setId(loginUser.getId());

        return loginResponse;
    }
}
