package com.example.evenementenkalenderbe.dto.EventCreator;

import com.example.evenementenkalenderbe.model.Event;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class EventCreatorInputDto {

   private Long id;
   private String name;
   private String email;
   private String phoneNumber;
   private String website;
   private String description;
   private String location;
   private List<Event> event;
}
