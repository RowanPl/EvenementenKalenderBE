package com.example.evenementenkalenderbe.dto.Event;


import com.example.evenementenkalenderbe.model.EventCreator;
import com.example.evenementenkalenderbe.model.EventType;
import com.example.evenementenkalenderbe.model.FileUploadResponse;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class EventOutputDto {
    public String nameOfEvent;
    public List<Date> dates = new ArrayList<>();
    public String linkToEvent;
    public EventType eventType;
    public String time;
    public String moreInformation;
    public FileUploadResponse file;
    public String location;
    public EventCreator eventCreator;
    private Long Id;

}