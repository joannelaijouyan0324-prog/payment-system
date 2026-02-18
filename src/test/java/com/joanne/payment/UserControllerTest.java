package com.joanne.payment;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joanne.payment.dto.CreateUserRequest;
import com.joanne.payment.dto.LoginRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCreateUserAndLoginSuccessfully() throws Exception {

        // Create user
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setUsername("joanne");
        createUserRequest.setEmail("joanne@gmail.com");
        createUserRequest.setPassword("123456");

        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createUserRequest)))
                .andExpect(status().isOk());

        // Login
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("joanne@gmail.com");
        loginRequest.setPassword("123456");

        mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginRequest)))
                .andExpect(status().isOk());
    }

    @Test
    void shouldFailLoginWithWrongPassword() throws Exception {

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("joanne@gmail.com");
        loginRequest.setPassword("wrong");

        mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginRequest)))
                .andExpect(status().isUnauthorized());
    }
}
