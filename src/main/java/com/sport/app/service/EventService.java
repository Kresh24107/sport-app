package com.sport.app.service;

import com.sport.app.repository.EventRepository;
import com.sport.app.repository.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    private EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void saveEvent(Event event) {
        eventRepository.save(event);
    }

    public Optional<Event> getEventById(int id) {
        return eventRepository.findById(id);
    }

    public void deleteById(int id) {
        eventRepository.deleteById(id);
    }

    public List<Event> getEventsByUserId(int id) {
        return eventRepository.getEventsByApplicationUserId(id);
    }

    public List<Event> getEventsByDate(Date date) {
        return eventRepository.findAllWithCreationDateTimeBefore(date);
    }
}
