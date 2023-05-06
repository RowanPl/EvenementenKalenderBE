package com.example.evenementenkalenderbe.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoleTest {

    @Test
    void getRolename() {
        //arrange
        Role r = new Role();
        r.setRolename("Admin");
        //act
        String result = r.getRolename();
        //assert
        assertEquals("Admin", result);
    }
}