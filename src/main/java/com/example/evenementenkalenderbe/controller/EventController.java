package com.example.evenementenkalenderbe.controller;

import com.example.evenementenkalenderbe.Exeptions.EventNotFoundException;
import com.example.evenementenkalenderbe.dto.EventDto;
import com.example.evenementenkalenderbe.model.FileUploadResponse;
import com.example.evenementenkalenderbe.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;
    private final PhotoController photoController;


    public EventController(EventService eventService, PhotoController photoController) {
        this.eventService = eventService;

        this.photoController = photoController;
    }

    @PostMapping
    public ResponseEntity<Long> createEvent(@RequestBody EventDto dto) {
        Long eventId = eventService.createEvent(dto).getId();
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(eventId).toUri();
        return ResponseEntity.created(location).body(eventId);
    }


    @GetMapping
    public ResponseEntity<Object> getEvents() {
        return ResponseEntity.ok().body(eventService.getAllEvents());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> getEventById(@PathVariable Long id) {
        return ResponseEntity.ok().body(eventService.getEventById(id));
    }


    @GetMapping("/category/{category}")
    public ResponseEntity<Object> getEventByCategory(@PathVariable String category) {

        return ResponseEntity.ok().body(eventService.getAllEventsByCategory(category));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEvent(@PathVariable Long id) {

        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<EventDto> updateEvent(@PathVariable Long id, @RequestBody EventDto dto) {

        EventDto updatedEventDto = eventService.updateEvent(id, dto);
        return ResponseEntity.ok(updatedEventDto);
    }

    @PostMapping("/{id}/upload")
    public ResponseEntity<Object> uploadPhoto(@PathVariable Long id, @RequestBody MultipartFile file) {

        FileUploadResponse photo = photoController.singelFileUpload(file);

        eventService.assignPhotoToEvent(id, photo.getFileName());
        return ResponseEntity.noContent().build();
    }


}

