package com.example.evenementenkalenderbe.dto.EventCreator;

import com.example.evenementenkalenderbe.model.Event;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class EventCreatorOutputDto {

    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String website;
    private String description;
    private String location;
    private List<Event> event;

}
