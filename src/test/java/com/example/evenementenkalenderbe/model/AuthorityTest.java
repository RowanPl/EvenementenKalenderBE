package com.example.evenementenkalenderbe.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthorityTest {

    @Test
    void shouldReturnCorrectUserName() {
        //assert
        Authority authority = new Authority();
        //act
        authority.setUsername("usernameTest");
        //assert
        assertEquals("usernameTest", authority.getUsername());

    }
    @Test
    void shouldReturnCorrectAuthority() {
        //assert
        Authority authority = new Authority("AuthorityTest", "ADMIN");
        //act
        //assert
        assertEquals("AuthorityTest", authority.getUsername());
        assertEquals("ADMIN", authority.getAuthority());

    }
}