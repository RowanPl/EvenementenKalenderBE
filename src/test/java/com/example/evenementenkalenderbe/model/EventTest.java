package com.example.evenementenkalenderbe.model;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EventTest {

    @Test
    void shouldReturnCorrectId() {
        //arrange
        Event e = new Event();
        e.setEventid(1L);
        //act
        Long result = e.getEventid();
        Long Result = e.getId();
        //assert
        assertEquals(1, result);
        assertEquals(1, Result);
    }


    @Test
    void shouldReturnNameOfEvent() {
        //arrange
        Event e = new Event();
        e.setNameOfEvent("Test");
        //act
        String result = e.getNameOfEvent();
        //assert
        assertEquals("Test", result);
    }

    @Test
    void shouldReturnDateOfEvent() {
        //arrange
        Event e = new Event();
        Date date = new Date("2020/01/01");
        Date date2 = new Date("2020/01/02");
        e.getDates().add(date);
        e.getDates().add(date2);

        //act
        List<Date> result = e.getDates();

        //assert
        assertEquals(2, result.size());
        assertEquals(date, result.get(0));
    }


    @Test
    void shouldReturnLinkOfEvent() {
        //arrange
        Event e = new Event();
        e.setLinkToEvent("www.test.com");
        //act
        String result = e.getLinkToEvent();
        //assert
        assertEquals("www.test.com", result);
    }

    @Test
    void shouldReturnCategoryOfEvent() {
        //arrange
        Event e = new Event();
        e.setEventType("Theater");
        //act
        String result = e.getEventType();
        //assert
        assertEquals("Theater", result);
    }

    @Test
    void shouldReturnStartTimeOfEvent() {
        //arrange
        Event e = new Event();
        e.setTime("12:00");
        //act
        String result = e.getTime();
        //assert
        assertEquals("12:00", result);
    }

    @Test
    void shouldReturnMoreInformationAboutEvent() {
        //arrange
        Event e = new Event();
        e.setMoreInformation("More information about this event: Test");
        //act
        String result = e.getMoreInformation();
        //assert
        assertEquals("More information about this event: Test", result);
    }

    @Test
    void shouldReturnFileUploadOfEvent() {
        //arrange
        Event e = new Event();
        FileUploadResponse f = new FileUploadResponse();
        f.setFileName("test");

        e.setFile(f);
        //act
        String result = e.getFile().getFileName();
        //assert
        assertEquals("test", result);
    }

    @Test
    void shouldReturnLocationOfEvent() {
        //arrange
        Event e = new Event();
        e.setLocation("Bennekom");
        //act
        String result = e.getLocation();
        //assert
        assertEquals("Bennekom", result);
    }

    @Test
    void shouldReturnEventCreator() {
        // arrange
        Event e = new Event();
        User u = new User();
        u.setUsername("Test Creator");
        e.setEventCreator(u.getUsername());
        // act
        String result = e.getEventCreator();
        // assert
        assertEquals("Test Creator", result);

    }


}