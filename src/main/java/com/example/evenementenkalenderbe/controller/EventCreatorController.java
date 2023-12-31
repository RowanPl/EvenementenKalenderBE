package com.example.evenementenkalenderbe.controller;

import com.example.evenementenkalenderbe.dto.EventCreator.EventCreatorInputDto;
import com.example.evenementenkalenderbe.dto.EventCreator.EventCreatorOutputDto;
import com.example.evenementenkalenderbe.service.EventCreatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/eventcreator")
public class EventCreatorController {


    private final EventCreatorService eventCreatorService;

    public EventCreatorController(EventCreatorService eventCreatorService) {
        this.eventCreatorService = eventCreatorService;
    }
    @GetMapping
    public List<EventCreatorOutputDto> getAllEventCreator() {
        return eventCreatorService.getAllEventCreator();
    }

    @PostMapping
    public ResponseEntity<EventCreatorOutputDto> createEventCreator(@RequestBody EventCreatorInputDto eventCreatorInputDto) {

         EventCreatorOutputDto eventCreatorOutputDto = eventCreatorService.createEventCreator(eventCreatorInputDto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(eventCreatorOutputDto.getId()).toUri();



        return ResponseEntity.created(uri).body(eventCreatorOutputDto);
    }


}
