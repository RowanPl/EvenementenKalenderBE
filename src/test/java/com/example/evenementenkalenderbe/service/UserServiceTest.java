package com.example.evenementenkalenderbe.service;


import com.example.evenementenkalenderbe.dto.UserDto;
import com.example.evenementenkalenderbe.model.User;
import com.example.evenementenkalenderbe.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;


    @Test
    public void shouldReturnCorrectUser() {
        // arrange
        User u = new User();
        u.setUsername("test");
        u.setPassword("testPassword");

        Mockito.when(userRepository.findById("test")).thenReturn(Optional.of(u));

        // act
        UserDto udto = userService.getUser("test");

        // assert
        assertEquals("test", udto.getUsername());
        assertEquals("testPassword", udto.getPassword());
    }

    @Test
    public void shouldThrowExceptionWhenUserNotFound() {
        // arrange
        String username = "nonexistent_user";
        Mockito.when(userRepository.findById(username)).thenReturn(Optional.empty());

        // act and assert
        assertThrows(UsernameNotFoundException.class, () -> userService.getUser(username));
    }


    @Test
    void shouldReturnCorrectUsers() {
        //arange
        User u = new User();
        u.setUsername("test");
        u.setPassword("testPassword");
        u.setEmail("test@Test.nl");
        u.setCreator(true);
        u.setNewsletter(true);
        u.setEnabled(true);

//act
        Mockito.when(userRepository.findAll()).thenReturn(Collections.singletonList(u));
        List<UserDto> userDtos = userService.getUsers();
        //assert
        assertEquals(1, userDtos.size());
        UserDto udto = userDtos.iterator().next();
        assertEquals("test", udto.getUsername());

    }
}