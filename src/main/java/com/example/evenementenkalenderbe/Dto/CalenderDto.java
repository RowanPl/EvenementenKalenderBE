package com.example.evenementenkalenderbe.Dto;

import com.example.evenementenkalenderbe.Model.Evenement;


import java.util.List;

public class CalenderDto {

    public Long id;
    public String typeOfCalender;
    public List<Evenement> events;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeOfCalender() {
        return typeOfCalender;
    }

    public void setTypeOfCalender(String typeOfCalender) {
        this.typeOfCalender = typeOfCalender;
    }

    public List<Evenement> getEvents() {
        return events;
    }

    public void setEvents(List<Evenement> events) {
        this.events = events;
    }
}
