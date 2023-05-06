package com.example.evenementenkalenderbe.controller;

import com.example.evenementenkalenderbe.Exeptions.AccessDeniedExcpetion;
import com.example.evenementenkalenderbe.Exeptions.EventNotFoundException;
import com.example.evenementenkalenderbe.Exeptions.UserNotAuthorized;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = EventNotFoundException.class)
    public ResponseEntity<Object> exception(EventNotFoundException exception) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(value = AccessDeniedExcpetion.class)
    public ResponseEntity<Object> exception(AccessDeniedExcpetion exception) {

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(exception.getMessage());
    }

    @ExceptionHandler(value = UserNotAuthorized.class)
    public ResponseEntity<Object> exception(UserNotAuthorized exception) {

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(exception.getMessage());
    }


}
