package com.example.evenementenkalenderbe.model;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Event")
public class Event {

    @JoinColumn(name = "file")
    @OneToOne
    FileUploadResponse file;
    @Id
    @GeneratedValue
    private Long Id;
    @NotNull
    private String nameOfEvent;
    @ElementCollection
    @Temporal(TemporalType.DATE)
    private List<Date> dates = new ArrayList<Date>();
    private String linkToEvent;
    private String eventType;
    private String time;
    @Column(name = "moreInformation", length = 10000)
    private String moreInformation;
    private String location;


    @Column(name = "eventCreator")
    private String eventCreator;


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

    public FileUploadResponse getFile() {
        return file;
    }

    public void setFile(FileUploadResponse file) {
        this.file = file;
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

    public Long getEventid() {
        return Id;
    }

    public void setEventid(Long Id) {
        this.Id = Id;
    }
}
