package com.example.evenementenkalenderbe.service;

import com.example.evenementenkalenderbe.dto.Event.EventOutputDto;
import com.example.evenementenkalenderbe.model.Event;
import com.example.evenementenkalenderbe.model.EventType;
import com.example.evenementenkalenderbe.model.FileUploadResponse;
import com.example.evenementenkalenderbe.model.User;
import com.example.evenementenkalenderbe.repository.EventRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EventServiceTest {

    @Mock
    EventRepository eventRepository;

    @InjectMocks
    EventService service;

    @Test
    void getAllEventsByUser() {
        // Arrange
        User u = new User();
        u.setUsername("Test Creator");

        EventOutputDto dto = new EventOutputDto();
        dto.setNameOfEvent("Test Event");
        dto.setLinkToEvent("http://example.com");
        dto.setEventType(EventType.THEATER);
        dto.setTime("12:00 PM");
        dto.setMoreInformation("Test Information");
        dto.setLocation("Test Location");

        Event savedEvent = new Event();
        savedEvent.setId(1L);
        savedEvent.setNameOfEvent(dto.getNameOfEvent());
        savedEvent.setLinkToEvent(dto.getLinkToEvent());
        savedEvent.setEventType(dto.getEventType());
        savedEvent.setTime(dto.getTime());
        savedEvent.setMoreInformation(dto.getMoreInformation());

        savedEvent.setLocation(dto.getLocation());
        savedEvent.setEventCreator(dto.getEventCreator());

        when(eventRepository.findAllByEventCreator(Mockito.anyString())).thenReturn(List.of(savedEvent));

        // Act
        List<EventOutputDto> result = service.getAllEventsByUser("Test Creator");

        // Assert
        assertEquals(1, result.size());
        assertEquals(dto.getNameOfEvent(), result.get(0).getNameOfEvent());
        assertEquals(dto.getLinkToEvent(), result.get(0).getLinkToEvent());

    }


    // test to get all events by category
    @Test
    void getAllEventsByCategory() {
        // Arrange
        FileUploadResponse f = new FileUploadResponse();
        f.setFileName("Test File");

        EventOutputDto dto = new EventOutputDto();
        dto.setNameOfEvent("Test Event");
        dto.setLinkToEvent("http://example.com");
        dto.setEventType(EventType.THEATER);
        dto.setTime("12:00 PM");
        dto.setMoreInformation("Test Information");
        dto.setFile(f);
        dto.setLocation("Test Location");

        Event savedEvent = new Event();
        savedEvent.setId(1L);
        savedEvent.setNameOfEvent(dto.getNameOfEvent());
        savedEvent.setLinkToEvent(dto.getLinkToEvent());
        savedEvent.setEventType(dto.getEventType());
        savedEvent.setTime(dto.getTime());
        savedEvent.setMoreInformation(dto.getMoreInformation());
        savedEvent.setFile(f);
        savedEvent.setLocation(dto.getLocation());
        savedEvent.setEventCreator(dto.getEventCreator());

        when(eventRepository.findAllByEventType(Mockito.anyString())).thenReturn(List.of(savedEvent));

        // Act
        List<EventOutputDto> result = service.getAllEventsByCategory("Test Type");

        //Assert
        assertEquals(1, result.size());
        assertEquals(dto.getNameOfEvent(), result.get(0).getNameOfEvent());

    }
}