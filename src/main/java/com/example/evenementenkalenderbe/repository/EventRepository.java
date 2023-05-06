package com.example.evenementenkalenderbe.repository;

import com.example.evenementenkalenderbe.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends CrudRepository<Event, String> {
    List<Event> findAllByEventType(String category);

    List<Event> findAllByDates(String date);

    Optional<Event> findById(Long id);

    List<Event> deleteById(Long id);

    List<Event> findAllByEventCreator(String CreatorName);

}
