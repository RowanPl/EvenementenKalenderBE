package com.example.evenementenkalenderbe.Exeptions;

public class UserNotAuthorized extends RuntimeException {

    public UserNotAuthorized(String username) {
        super("User: " + username + " is not authorized to perform this action");
    }
}
