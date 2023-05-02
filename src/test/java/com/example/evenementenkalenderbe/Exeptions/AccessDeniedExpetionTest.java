package com.example.evenementenkalenderbe.Exeptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccessDeniedExpetionTest {

    @Test
    void shouldReturnCorrectMessage() {
        //arrange
        AccessDeniedExcpetion e = new AccessDeniedExcpetion("test");
        //act
        String result = e.getMessage();
        //assert
        assertEquals("test", result);
    }

}