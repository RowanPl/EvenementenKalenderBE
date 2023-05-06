package com.example.evenementenkalenderbe.controller;

import com.example.evenementenkalenderbe.dto.UserDto;
import com.example.evenementenkalenderbe.repository.UserRepository;
import com.example.evenementenkalenderbe.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserRepository userRepos;
    private final UserService userService;


    private final PasswordEncoder encoder;

    public UserController(UserRepository userRepos, UserService userService, PasswordEncoder encoder) {
        this.userRepos = userRepos;
        this.userService = userService;
        this.encoder = encoder;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<UserDto>> getUsers() {

        List<UserDto> userDtos = userService.getUsers();

        return ResponseEntity.ok().body(userDtos);
    }

    @GetMapping(value = "/{username}")
    public ResponseEntity<UserDto> getUser(@PathVariable String username) {

        UserDto userDto = userService.getUser(username);

        return ResponseEntity.ok().body(userDto);
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createUser(@Valid @RequestBody UserDto dto) {

        if (dto.getPassword().length() < 8) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Password must be at least 8 characters long");
        } else {
            String newUsername = userService.createUser(dto);
            if (dto.creator) {
                userService.addAuthority(newUsername, "CREATOR");
            } else {
                userService.addAuthority(newUsername, "USER");
            }
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}").buildAndExpand(newUsername).toUri();
            return ResponseEntity.created(location).build();
        }
    }

    @PutMapping(value = "/{username}")
    public ResponseEntity<Object> updateUser(@Valid @PathVariable String username, @RequestBody UserDto dto) {
        if (dto.getPassword().length() < 8) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Password must be at least 8 characters long");
        } else {
            userService.updateUser(username, dto);
            return ResponseEntity.ok().build();
        }

    }
}
