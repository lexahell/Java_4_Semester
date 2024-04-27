package com.example.demo;

import com.example.demo.model.DTO.UserDTO;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AuthorizationService;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;


@ExtendWith(MockitoExtension.class)
public class AuthorizationServiceTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    PasswordEncoder passwordEncoder;

    @Test
    void signup(){
        UserService userService = new UserService(userRepository);

        UserDTO userdto1 = new UserDTO("John", "12345");
        UserDTO userdto2 = new UserDTO("Janne", "54321");
        UserDTO userdto3 = new UserDTO("Joseph", "abc");

        Mockito.when(userRepository.existsByUsername("John")).thenReturn(true);
        Mockito.when(userRepository.existsByUsername("Joseph")).thenReturn(false);

        Mockito.when(passwordEncoder.encode(Mockito.anyString())).thenAnswer(invocation -> invocation.getArgument(0));

        AuthorizationService authorizationService = new AuthorizationService(passwordEncoder, userService);

        Assertions.assertFalse(authorizationService.signUp(userdto1));
        Assertions.assertTrue(authorizationService.signUp(userdto3));
    }
}
