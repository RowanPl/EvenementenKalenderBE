package com.example.evenementenkalenderbe.service;


import com.example.evenementenkalenderbe.Exeptions.AccessDeniedExcpetion;
import com.example.evenementenkalenderbe.Exeptions.EventNotFoundException;
import com.example.evenementenkalenderbe.dto.EventDto;
import com.example.evenementenkalenderbe.model.Event;
import com.example.evenementenkalenderbe.model.FileUploadResponse;
import com.example.evenementenkalenderbe.model.User;
import com.example.evenementenkalenderbe.repository.EventRepository;
import com.example.evenementenkalenderbe.repository.FileUploadRepository;
import com.example.evenementenkalenderbe.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    private final FileUploadRepository fileUploadRepository;

    public EventService(EventRepository eventRepository, UserRepository userRepository, FileUploadRepository fileUploadRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
        this.fileUploadRepository = fileUploadRepository;
    }


    public static EventDto fromEvent(Event event) {

        EventDto dto = new EventDto();

        dto.setNameOfEvent(event.getNameOfEvent());
        dto.setDates(event.getDates());
        dto.setLinkToEvent(event.getLinkToEvent());
        dto.setEventType(event.getEventType());
        dto.setTime(event.getTime());
        dto.setMoreInformation(event.getMoreInformation());
        dto.setLocation(event.getLocation());
        dto.setEventCreator(event.getEventCreator());
        dto.setFileUpload(event.getFile());

        return dto;
    }


    private boolean isAdmin(String username) {
        User user = userRepository.findByUsername(username);
        return user.getAuthorities().stream().anyMatch(auth -> auth.getAuthority().equals("ADMIN"));
    }

    public List<Event> getAllEvents() {
        EventDto dto = new EventDto();
        List<Event> events = (List<Event>) eventRepository.findAll();
        return events;
    }


    public EventDto getEventById(Long id) {
        if (id == null) throw new EventNotFoundException(id);
        EventDto dto = new EventDto();
        Optional<Event> event = eventRepository.findById(id);
        if (event.isPresent()) {
            dto = fromEvent(event.get());
        } else {
            throw new EventNotFoundException(id);
        }
        return dto;
    }


    public EventDto createEvent(EventDto dto) {
        String username = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            username = authentication.getName();
        } else {
            throw new AccessDeniedExcpetion( "You need to be logged in to create an event");
        }

        // Create and save the event using the authenticated username
        Event event = new Event();
        event.setNameOfEvent(dto.getNameOfEvent());
        event.setDates(dto.getDates());
        event.setLinkToEvent(dto.getLinkToEvent());
        event.setEventType(dto.getEventType());
        event.setTime(dto.getTime());
        event.setMoreInformation(dto.getMoreInformation());
        event.setLocation(dto.getLocation());
        event.setEventCreator(username);
        event.setFile(dto.getFileUpload());
        eventRepository.save(event);
        event.setId(event.getId());
        eventRepository.save(event);
        dto.setId(event.getId());

        return dto;
    }



    public EventDto updateEvent(Long id, EventDto dto) {
        Optional<Event> optionalEvent = eventRepository.findById(id);
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if (optionalEvent.isPresent()) {
            Event event = optionalEvent.get();
            if (isAdmin(username) || event.getEventCreator().equals(username)) { // check if the authenticated user is the creator of the event
                event.setNameOfEvent(dto.getNameOfEvent());
                event.setDates(dto.getDates());
                event.setLinkToEvent(dto.getLinkToEvent());
                event.setEventType(dto.getEventType());
                event.setTime(dto.getTime());
                event.setMoreInformation(dto.getMoreInformation());
                event.setLocation(dto.getLocation());
                event.setEventCreator(username);
                event.setFile(dto.getFileUpload());
                eventRepository.save(event);

                return fromEvent(event);
            } else {
                throw new AccessDeniedExcpetion("Access Denied, your not authorized"); // throw an exception if the authenticated user is not the creator of the event
            }
        } else {
            throw new EventNotFoundException(id);
        }
    }



    @Transactional
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    public List<Event> getAllEventsByUser(String CreatorName) {
        EventDto dto = new EventDto();
        List<Event> events = eventRepository.findAllByEventCreator(CreatorName);
        return events;
    }


    public List<Event> getAllEventsByCategory(String category) {
        EventDto dto = new EventDto();
        List<Event> events = eventRepository.findAllByEventType(category);
        return events;
    }

    public void assignPhotoToEvent(Long Id, String name) {

        Optional<Event> optionalEvent = eventRepository.findById(Id);

        Optional<FileUploadResponse> fileUploadResponse = fileUploadRepository.findByFileName(name);

        if (optionalEvent.isPresent() && fileUploadResponse.isPresent()) {

            FileUploadResponse photo = fileUploadResponse.get();

            Event event = optionalEvent.get();
            event.setFile(photo);
            eventRepository.save(event);

        }

    }

}
