package com.example.evenementenkalenderbe.service;


import com.example.evenementenkalenderbe.Exeptions.AccessDeniedException;
import com.example.evenementenkalenderbe.Exeptions.EventNotFoundException;
import com.example.evenementenkalenderbe.dto.Event.EventOutputDto;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.evenementenkalenderbe.utils.PropertyMapper.copyProperties;

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


    public static EventOutputDto fromEventToDto(Event event) {

        EventOutputDto dto = new EventOutputDto();
        copyProperties(event, dto);

        return dto;
    }


    private boolean isAdmin(String username) {
        User user = userRepository.findByUsername(username);
        return user.getAuthorities().stream().anyMatch(auth -> auth.getAuthority().equals("ADMIN"));
    }

    public List<EventOutputDto> getAllEvents() {
        List<EventOutputDto> dto = new ArrayList<>();
        List<Event> events = (List<Event>) eventRepository.findAll();
        events.forEach(event -> dto.add(fromEventToDto(event)));
        return dto;
    }


    public EventOutputDto getEventById(Long id) {
        if (id == null) throw new EventNotFoundException(id);
        EventOutputDto dto = new EventOutputDto();
        Optional<Event> event = eventRepository.findById(id);
        if (event.isPresent()) {
            dto = fromEventToDto(event.get());
        } else {
            throw new EventNotFoundException(id);
        }
        return dto;
    }


    public EventOutputDto createEvent(EventOutputDto dto) {
        String username = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            username = authentication.getName();
        } else {
            throw new AccessDeniedException( "You need to be logged in to create an event");
        }
        // Create and save the event using the authenticated username
        Event event = new Event();
        copyProperties(dto, event);
        eventRepository.save(event);
        dto.setId(event.getId());
        return dto;
    }



    public EventOutputDto updateEvent(Long id, EventOutputDto dto) {
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
                event.setEventCreator(dto.getEventCreator());
                event.setFile(dto.getFile());
                eventRepository.save(event);

                return fromEventToDto(event);
            } else {
                throw new AccessDeniedException("Access Denied, your not authorized"); // throw an exception if the authenticated user is not the creator of the event
            }
        } else {
            throw new EventNotFoundException(id);
        }
    }



    @Transactional
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    public List<EventOutputDto> getAllEventsByUser(String CreatorName) {
        List<EventOutputDto> dto = new ArrayList<>();
        List<Event> events = eventRepository.findAllByEventCreator(CreatorName);
        events.forEach(event -> dto.add(fromEventToDto(event)));
        return dto;
    }


    public List<EventOutputDto> getAllEventsByCategory(String category) {
        List<EventOutputDto> dto = new ArrayList<>();
        List<Event> events = eventRepository.findAllByEventType(category);
        events.forEach(event -> dto.add(fromEventToDto(event)));
        return dto;
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
