package com.example.evenementenkalenderbe.dto;


import com.example.evenementenkalenderbe.model.Authority;

import java.util.Set;

public class UserDto {

    public String username;
    public String password;
    public Boolean enabled;
    public String email;
    public Set<Authority> authorities;
    public boolean newsletter;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public void getEnabled(boolean enabled) {
        this.enabled = enabled;
    }


    public boolean isNewsletter() {
        return newsletter;
    }

    public void setNewsletter(boolean newsletter) {
        this.newsletter = newsletter;
    }
}

