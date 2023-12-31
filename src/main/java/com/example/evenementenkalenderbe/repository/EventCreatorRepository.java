package com.example.evenementenkalenderbe.repository;

import com.example.evenementenkalenderbe.dto.EventCreator.EventCreatorOutputDto;
import com.example.evenementenkalenderbe.model.EventCreator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventCreatorRepository extends JpaRepository<EventCreator, Long> {

}
