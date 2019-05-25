package com.sport.app.service;

import com.backend.repository.EventRepository;
import com.backend.repository.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventService {
    private EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void saveEvent(Event event){
        eventRepository.save(event);
    }

    public Optional<Event> getEventById(int id){
        return eventRepository.findById(id);
    }

}
