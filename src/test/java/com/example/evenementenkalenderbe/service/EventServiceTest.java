package com.example.evenementenkalenderbe.service;

import com.example.evenementenkalenderbe.dto.EventDto;
import com.example.evenementenkalenderbe.model.Event;
import com.example.evenementenkalenderbe.model.FileUploadResponse;
import com.example.evenementenkalenderbe.model.User;
import com.example.evenementenkalenderbe.repository.EventRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.test.context.support.WithMockUser;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class EventServiceTest {

    @Mock
    EventRepository eventRepository;

    @InjectMocks
    EventService service;

    @Test
    @WithMockUser(username = "test", password = "test", authorities = "CREATOR")
    void shouldCreateEvent() {

        //arrange
        EventDto dto = new EventDto();
        dto.setNameOfEvent("Test Event");
        dto.setLinkToEvent("http://example.com");
        dto.setEventType("Test Type");
        dto.setTime("12:00 PM");
        dto.setMoreInformation("Test Information");
        dto.setLocation("Test Location");
        dto.setEventCreator("test");

        Event savedEvent = new Event();
        savedEvent.setId(1L);
        savedEvent.setNameOfEvent(dto.getNameOfEvent());
        savedEvent.setLinkToEvent(dto.getLinkToEvent());
        savedEvent.setEventType(dto.getEventType());
        savedEvent.setTime(dto.getTime());
        savedEvent.setMoreInformation(dto.getMoreInformation());
        savedEvent.setLocation(dto.getLocation());
        savedEvent.setEventCreator(dto.getEventCreator());

        Mockito.when(eventRepository.save(Mockito.any(Event.class))).thenReturn(savedEvent);

        //act
        EventDto result = service.createEvent(dto);

        //assert
        assertEquals(dto.getNameOfEvent(), result.getNameOfEvent());
        assertEquals(dto.getLinkToEvent(), result.getLinkToEvent());
        assertEquals(dto.getEventType(), result.getEventType());
        assertEquals(dto.getTime(), result.getTime());
        assertEquals(dto.getMoreInformation(), result.getMoreInformation());
        assertEquals(dto.getLocation(), result.getLocation());
        assertEquals(dto.getEventCreator(), result.getEventCreator());

    }


    @Test
    void getAllEventsByUser() {
        // Arrange
        User u = new User();
        u.setUsername("Test Creator");

        EventDto dto = new EventDto();
        dto.setNameOfEvent("Test Event");
        dto.setLinkToEvent("http://example.com");
        dto.setEventType("Test Type");
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

        Mockito.when(eventRepository.findAllByEventCreator(Mockito.anyString())).thenReturn(List.of(savedEvent));

        // Act
        List<Event> result = service.getAllEventsByUser("Test Creator");

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

        EventDto dto = new EventDto();
        dto.setNameOfEvent("Test Event");
        dto.setLinkToEvent("http://example.com");
        dto.setEventType("Test Type");
        dto.setTime("12:00 PM");
        dto.setMoreInformation("Test Information");
        dto.setFileUpload(f);
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

        Mockito.when(eventRepository.findAllByEventType(Mockito.anyString())).thenReturn(List.of(savedEvent));

        // Act
        List<Event> result = service.getAllEventsByCategory("Test Type");

        //Assert
        assertEquals(1, result.size());
        assertEquals(dto.getNameOfEvent(), result.get(0).getNameOfEvent());

    }
}