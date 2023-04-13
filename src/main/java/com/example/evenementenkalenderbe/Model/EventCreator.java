package com.example.evenementenkalenderbe.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Entity
public class EventCreator {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String creatorName;

    @OneToMany(mappedBy = "eventCreator")
    private List<Evenement> events;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public List<Evenement> getEvents() {
        return events;
    }

    public void setEvents(List<Evenement> events) {
        this.events = events;
    }
}
