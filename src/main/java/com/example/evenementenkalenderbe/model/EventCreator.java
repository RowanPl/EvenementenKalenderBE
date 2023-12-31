package com.example.evenementenkalenderbe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;
import lombok.Getter;

import java.util.List;


@Entity
@Data
@Table(name = "EventCreator")
public class EventCreator {

    @Id
    @GeneratedValue()
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String website;
    private String description;
    private String location;
    @OneToMany(mappedBy = "eventCreator")
    private List<Event> event;

    @JsonIgnore
    @OneToMany(mappedBy = "eventCreator")
    private List<User> users;



}
