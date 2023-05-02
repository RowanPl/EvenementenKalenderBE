package com.example.evenementenkalenderbe.Exeptions;

public class EventNotFoundException extends RuntimeException {

    public EventNotFoundException(Long id) {
        super("Could not find event with id: " + id);
    }
}
