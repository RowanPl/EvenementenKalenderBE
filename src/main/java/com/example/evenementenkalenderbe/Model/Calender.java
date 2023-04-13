package com.example.evenementenkalenderbe.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Calendar")
public class Calender {

    @Id
    @GeneratedValue
    private Long id;

    private String typeOfCalender;

    @OneToMany(mappedBy = "calendar")
    private List<Evenement> events;

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