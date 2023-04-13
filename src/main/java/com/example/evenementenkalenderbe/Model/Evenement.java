package com.example.evenementenkalenderbe.Model;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "Event")
public class Evenement {

    @Id
    @GeneratedValue
    private Long Id;

    private String nameOfEvent;
    private Date date;
    private String linkToEvent;
    private String eventType;
    private Time time;
    private String moreInformation;
    private String fileUpload;
    private String location;

    @ManyToOne
    private EventCreator eventCreator;
}
