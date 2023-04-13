package com.example.evenementenkalenderbe.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class EventCreator {

    @Id
    @GeneratedValue
    private long id;

    private String creatorName;

    @OneToMany(mappedBy = "eventCreator")
    private List<Evenement> events;
}
