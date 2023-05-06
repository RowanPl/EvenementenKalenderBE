package com.example.evenementenkalenderbe.Exeptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class EventNotFoundExceptionTest {

    @Test
    void shouldReturnCorrectMessage() {
        //arrange
        EventNotFoundException e = new EventNotFoundException(1L);
        //act
        String result = e.getMessage();
        //assert
        assertEquals("Could not find event with id: 1", result);
    }

}