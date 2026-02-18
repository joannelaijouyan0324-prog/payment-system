package com.joanne.payment.service;

import com.joanne.payment.entity.User;
import com.joanne.payment.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String username, String email, String passwordHash) {

        // Create a new user
        User user = new User();

        // Set the parameters
        user.setEmail(email);
        user.setUsername(username);
        user.setPasswordHash(passwordHash);
        user.setStatus("ACTIVE");

        // The time for now
        LocalDateTime now = LocalDateTime.now();

        user.setCreatedAt(now);
        user.setUpdatedAt(now);

        return this.userRepository.save(user);
    }

    public User login(String email, String password){

        Optional<User> user = userRepository.findByEmail(email);

        if(user.isEmpty()){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid email or password");
        }

        if(!user.get().getPasswordHash().equals(password)){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid email or password");
        }

        return user.get();
    }
}
