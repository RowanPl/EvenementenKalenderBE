package com.example.evenementenkalenderbe.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileUploadResponseTest {

    @Test
    void shouldReturnCorrectFileName() {
        //assert
        FileUploadResponse fileUploadResponse = new FileUploadResponse();
        //act
        fileUploadResponse.setFileName("test");
        //assert
        assertEquals("test", fileUploadResponse.getFileName());

    }

    @Test
    void shouldReturnCorrectContentType() {
        //assert
        FileUploadResponse fileUploadResponse = new FileUploadResponse();
        //act
        fileUploadResponse.setContentType("test");
        //assert
        assertEquals("test", fileUploadResponse.getContentType());

    }

    @Test
    void shouldReturnCorrectUrl() {
        //assert
        FileUploadResponse fileUploadResponse = new FileUploadResponse();
        //act
        fileUploadResponse.setUrl("test");
        //assert
        assertEquals("test", fileUploadResponse.getUrl());
    }

    @Test
    void shouldReturnCorrectFileUploadResponse(){
        //assert
        //act
        FileUploadResponse fileUploadResponse = new FileUploadResponse("test", "jpg", "www.example.org");

        //assert
        assertEquals("test", fileUploadResponse.getFileName());
        assertEquals("jpg", fileUploadResponse.getContentType());
        assertEquals("www.example.org", fileUploadResponse.getUrl());
    }
}