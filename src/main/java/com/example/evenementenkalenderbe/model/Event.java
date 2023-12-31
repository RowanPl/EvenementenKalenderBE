package com.example.evenementenkalenderbe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
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
    private List<Date> dates = new ArrayList<>();
    private String linkToEvent;
    @Enumerated(EnumType.STRING)
    private EventType eventType;
    private String time;
    @Column(name = "moreInformation", length = 10000)
    private String moreInformation;
    private String location;
    @ManyToOne
    @JsonIgnore
    private EventCreator eventCreator;



    public Event() {
    }
}