package com.example.evenementenkalenderbe.model;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserTest {

    @Test
    void shouldReturnUserName() {
        //arrange
        User u = new User();
        u.setUsername("User1");
        //act
        String result = u.getUsername();
        //assert
        assertEquals("User1", result);
    }

    @Test
    void shouldReturnCorrectUsernameAfterChange() {
        //arrange
        User u = new User();
        //act
        u.setUsername("User2");
        u.setUsername("User3");
        //assert
        assertEquals("User3", u.getUsername());

    }

    @Test
    void shouldReturnPassword() {
        //arrange
        User u = new User();
        u.setPassword("Password");
        //act
        String result = u.getPassword();
        //assert
        assertEquals("Password", result);
    }

    @Test
    void shouldReturnTrueIfUserIsEnabled() {
        //arrange
        User u = new User();
        u.setEnabled(true);
        //act
        boolean result = u.isEnabled();
        //assert
        assertTrue(result);

    }

    @Test
    void ShouldReturnTrueIfUserIsCreator() {
        //arrange
        User u = new User();
        u.setCreator(true);
        //act
        boolean result = u.isCreator();
        //assert
        assertTrue(result);
    }

    @Test
    void shouldReturnEmailOfUser() {
        //arrange
        User u = new User();
        u.setEmail("test@Test.nl");
        //act
        String result = u.getEmail();
        //assert
        assertEquals("test@Test.nl", result);
    }

    @Test
    void shouldAddAuthorityAndReturnIt() {
        //arrange
        User u = new User();
        Authority a = new Authority();
        a.setAuthority("ROLE_USER");
        //act
        u.addAuthority(a);
        //assert
        assertEquals("ROLE_USER", u.getAuthorities().iterator().next().getAuthority());


    }

    @Test
    void shouldReturnTrueIfUserIsSubscribedToTheNewsLetter() {
        //arrange
        User u = new User();
        u.setNewsletter(true);
        //act
        boolean result = u.isNewsletter();
        //assert
        assertTrue(result);
    }

    @Test
    void removeAuthority() {
        //arrange
        User u = new User();
        Authority a = new Authority();
        a.setAuthority("ROLE_USER");
        u.addAuthority(a);
        //act
        u.removeAuthority(a);
        //assert
        assertEquals(0, u.getAuthorities().size());
    }

    @Test
    void getRoles() {
        //arrange
        User u = new User();
        Role r = new Role();
        r.setRolename("ROLE_USER");
        //act
        u.setRoles(Set.of(r));
        //assert
        assertEquals("ROLE_USER", u.getRoles().iterator().next().getRolename());

    }


    @Test
    void setAuthorities() {
        //arrange
        User u = new User();
        Authority a = new Authority();
        a.setAuthority("ROLE_USER");
        //act
        u.setAuthorities(Set.of(a));
        //assert
        assertEquals("ROLE_USER", u.getAuthorities().iterator().next().getAuthority());
    }
}