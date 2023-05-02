package com.example.evenementenkalenderbe.dto;


import com.example.evenementenkalenderbe.model.FileUploadResponse;
import jakarta.persistence.Lob;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventDto {
    public String nameOfEvent;
    public List<Date> dates = new ArrayList<>();
    public String linkToEvent;
    public String eventType;
    public String time;
    @Lob
    public String moreInformation;
    @Lob
    public FileUploadResponse file;
    public String location;
    public String eventCreator;
    private Long Id;


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

    public List<Date> getDates() {
        return dates;
    }

    public void setDates(List<Date> dates) {
        this.dates = dates;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMoreInformation() {
        return moreInformation;
    }

    public void setMoreInformation(String moreInformation) {
        this.moreInformation = moreInformation;
    }

    public FileUploadResponse getFileUpload() {
        return file;
    }

    public void setFileUpload(FileUploadResponse fileUpload) {
        this.file = fileUpload;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEventCreator() {
        return eventCreator;
    }

    public void setEventCreator(String eventCreator) {
        this.eventCreator = eventCreator;
    }

}