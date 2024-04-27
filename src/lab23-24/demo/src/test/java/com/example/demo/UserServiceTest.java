package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static com.example.demo.model.User.Role.USER;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Test
    void create(){
        User user1 = new User("John", "12345", USER);
        User user2 = new User("Janne", "54321", USER);

        User user3 = new User("Joseph", "abc", USER);

        Mockito.when(userRepository.existsByUsername("John")).thenReturn(true);
        Mockito.when(userRepository.existsByUsername("Joseph")).thenReturn(false);

        UserService userService = new UserService(userRepository);

        Assertions.assertFalse(userService.create(user1));
        Assertions.assertTrue(userService.create(user3));
    }
    @Test
    void find(){
        User user1 = new User("John", "12345", USER);
        User user2 = new User("Janne", "54321", USER);

        User user3 = new User("Joseph", "abc", USER);

        Mockito.when(userRepository.findByUsername("John")).thenReturn(Optional.of(user1));
        Mockito.when(userRepository.findByUsername("Joseph")).thenReturn(Optional.empty());

        UserService userService = new UserService(userRepository);

        Assertions.assertEquals(userService.getByUsername("John"), user1);
        Assertions.assertThrows(UsernameNotFoundException.class, () -> {userService.getByUsername("Joseph");});
    }
}
