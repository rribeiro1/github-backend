package com.vanhack.github.service;

import com.vanhack.github.domain.Actor;
import com.vanhack.github.domain.Event;
import com.vanhack.github.controller.exception.ResourceNotFoundException;
import com.vanhack.github.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    private EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event save(Event event) {
        if (eventRepository.existsById(event.getId())) {
            throw new ResourceNotFoundException(String.format("Event %s already exists", event.getId()));
        }
        return eventRepository.save(event);
    }

    public List<Event> findAll() {
        return eventRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Event::getId))
                .collect(Collectors.toList());
    }

    public void deleteAll() {
        eventRepository.deleteAll();
    }

    public List<Event> findEventsByActor(Actor actor) {
       return eventRepository.findByActor(actor);
    }
}
