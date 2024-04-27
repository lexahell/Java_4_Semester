package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.model.DTO.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.example.demo.model.User.Role.USER;

@AllArgsConstructor
@Service
public class AuthorizationService {
    PasswordEncoder passwordEncoder;
    private final UserService userService;

    public boolean signUp(UserDTO userData) {

        User user = new User(userData.getUsername(), passwordEncoder.encode(userData.getPassword()), USER);

        return userService.create(user);
    }
}
