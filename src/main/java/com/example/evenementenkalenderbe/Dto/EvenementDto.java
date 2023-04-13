package com.example.evenementenkalenderbe.Dto;

import com.example.evenementenkalenderbe.Model.Calender;
import com.example.evenementenkalenderbe.Model.EventCreator;

import java.sql.Time;
import java.util.Date;

public class EvenementDto {
    private Long Id;


    public String nameOfEvent;
    public Date date;
    public String linkToEvent;
    public String eventType;
    public Time time;
    public String moreInformation;
    public String fileUpload;
    public String location;
    public EventCreator eventCreator;
    public Calender calender;

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

    public Calender getCalender() {
        return calender;
    }

    public void setCalender(Calender calender) {
        this.calender = calender;
    }
}
