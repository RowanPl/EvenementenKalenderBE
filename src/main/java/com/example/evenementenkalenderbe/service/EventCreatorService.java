package com.example.evenementenkalenderbe.service;

import com.example.evenementenkalenderbe.dto.EventCreator.EventCreatorInputDto;
import com.example.evenementenkalenderbe.dto.EventCreator.EventCreatorOutputDto;
import com.example.evenementenkalenderbe.model.EventCreator;
import com.example.evenementenkalenderbe.repository.EventCreatorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.evenementenkalenderbe.utils.PropertyMapper.copyProperties;

@Service
public class EventCreatorService {

    private final EventCreatorRepository eventCreatorRepository;

    public EventCreatorService(EventCreatorRepository eventCreatorRepository) {
        this.eventCreatorRepository = eventCreatorRepository;
    }

    public EventCreatorOutputDto fromEventCreatorToEventCreatorOutputDto(EventCreator eventCreator) {
        EventCreatorOutputDto eventCreatorOutputDto = new EventCreatorOutputDto();
        copyProperties(eventCreator, eventCreatorOutputDto);
        return eventCreatorOutputDto;
    }

    public EventCreator fromEventCreatorinputDtoToEventCreator(EventCreatorInputDto eventCreatorInputDto) {
        EventCreator eventCreator = new EventCreator();
        copyProperties(eventCreatorInputDto, eventCreator);
        return eventCreator;
    }

    public List<EventCreatorOutputDto> getAllEventCreator() {
        List<EventCreator> eventCreatorList = eventCreatorRepository.findAll();
        List<EventCreatorOutputDto> eventCreatorOutputDtoList = new ArrayList<>();
        for (EventCreator eventCreator : eventCreatorList) {
            eventCreatorOutputDtoList.add(fromEventCreatorToEventCreatorOutputDto(eventCreator));
        }
        return eventCreatorOutputDtoList;
    }

    public EventCreatorOutputDto createEventCreator(EventCreatorInputDto eventCreatorInputDto) {

        EventCreator eventCreator = fromEventCreatorinputDtoToEventCreator(eventCreatorInputDto);

        EventCreator savedEventCreator = eventCreatorRepository.save(eventCreator);

        return fromEventCreatorToEventCreatorOutputDto(savedEventCreator);
    }


}
