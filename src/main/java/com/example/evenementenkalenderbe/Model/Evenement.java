package com.example.evenementenkalenderbe.Model;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;


import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "Event")
public class Evenement {

    @Id
    @GeneratedValue
    private Long Id;

    @NotNull
    private String nameOfEvent;
    @NotNull
    private Date date;
    @NotNull
    private String linkToEvent;
    @NotNull
    private String eventType;
    @NotNull
    private Time time;
    @NotNull
    private String moreInformation;
    @NotNull
    private String fileUpload;
    @NotNull
    private String location;

    @ManyToOne
    private EventCreator eventCreator;

    @ManyToOne
    private Calender calender;


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNameOfEvent() {
        return nameOfEvent;
    }

    public void setNameOfEvent(String nameOfEvent) {
        this.nameOfEvent = nameOfEvent;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLinkToEvent() {
        return linkToEvent;
    }

    public void setLinkToEvent(String linkToEvent) {
        this.linkToEvent = linkToEvent;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getMoreInformation() {
        return moreInformation;
    }

    public void setMoreInformation(String moreInformation) {
        this.moreInformation = moreInformation;
    }

    public String getFileUpload() {
        return fileUpload;
    }

    public void setFileUpload(String fileUpload) {
        this.fileUpload = fileUpload;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public EventCreator getEventCreator() {
        return eventCreator;
    }

    public void setEventCreator(EventCreator eventCreator) {
        this.eventCreator = eventCreator;
    }
}
