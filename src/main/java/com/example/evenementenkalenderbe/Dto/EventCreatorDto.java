package com.example.evenementenkalenderbe.Dto;

import com.example.evenementenkalenderbe.Model.Evenement;
import java.util.List;

public class EventCreatorDto {


    public long id;
    public String creatorName;
    public List<Evenement> events;

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

