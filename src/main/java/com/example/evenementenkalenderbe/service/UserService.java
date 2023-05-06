package com.example.evenementenkalenderbe.service;

import com.example.evenementenkalenderbe.dto.UserDto;
import com.example.evenementenkalenderbe.model.Authority;
import com.example.evenementenkalenderbe.model.User;
import com.example.evenementenkalenderbe.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public static UserDto fromUser(User user) {

        var dto = new UserDto();

        dto.username = user.getUsername();
        dto.password = user.getPassword();
        dto.enabled = user.isEnabled();
        dto.email = user.getEmail();
        dto.authorities = user.getAuthorities();
        dto.creator = user.isCreator();
        dto.newsletter = user.isNewsletter();

        return dto;
    }

    public UserDto getUser(String username) {
        UserDto dto = new UserDto();
        Optional<User> user = userRepository.findById(username);
        if (user.isPresent()) {
            dto = fromUser(user.get());
        } else {
            throw new UsernameNotFoundException(username);
        }
        return dto;
    }

    public String createUser(UserDto userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User newUser = userRepository.save(toUser(userDto));
        return newUser.getUsername();
    }

    public User toUser(UserDto userDto) {

        var user = new User();

        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEnabled(userDto.getEnabled());
        user.setEmail(userDto.getEmail());
        user.setCreator(userDto.isCreator());
        user.setNewsletter(userDto.isNewsletter());

        return user;
    }

    public Set<Authority> getAuthorities(String username) {
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).get();
        UserDto userDto = fromUser(user);
        return userDto.getAuthorities();
    }

    public void addAuthority(String username, String authority) {

        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).get();
        user.addAuthority(new Authority(username, authority));
        userRepository.save(user);
    }

    public List<UserDto> getUsers() {
        List<UserDto> collection = new ArrayList<>();
        List<User> list = (List<User>) userRepository.findAll();
        for (User user : list) {
            collection.add(fromUser(user));
        }
        return collection;
    }

    public void updateUser(String username, UserDto dto) {
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).get();
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setEnabled(dto.getEnabled());
        user.setEmail(dto.getEmail());
        user.setCreator(dto.isCreator());
        user.setNewsletter(dto.isNewsletter());

        removeAuthority(user.getUsername(), "CREATOR");
        removeAuthority(user.getUsername(), "USER");

        if (!user.isCreator()) {
            removeAuthority(user.getUsername(), "CREATOR");
            addAuthority(user.getUsername(), "USER");
        } else {
            addAuthority(user.getUsername(), "CREATOR");
        }

        userRepository.save(user);
    }


    public void removeAuthority(String username, String authority) {
        User user = userRepository.findById(username).get();
        Set<Authority> authorities = user.getAuthorities();
        Authority authorityToRemove = authorities.stream().filter(a -> a.getAuthority().equals(authority)).findFirst().orElse(null);
        if (authorityToRemove != null) {
            authorities.remove(authorityToRemove);
            user.setAuthorities(authorities);
            userRepository.save(user);
        }
    }

}

