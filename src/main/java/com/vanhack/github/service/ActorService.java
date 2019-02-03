package com.vanhack.github.service;

import com.vanhack.github.domain.Actor;
import com.vanhack.github.domain.Event;
import com.vanhack.github.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ActorService {

    private ActorRepository actorRepository;
    private EventService eventService;

    @Autowired
    public ActorService(ActorRepository actorRepository, EventService eventService) {
        this.actorRepository = actorRepository;
        this.eventService = eventService;
    }

    public Actor save(Actor actor) {
        return actorRepository.save(actor);
    }

    public Actor findById(String id) throws NoSuchElementException {
        return actorRepository.findById(id).orElseThrow
                (() -> new NoSuchElementException(String.format("Actor with ID '%s' does not exists", id)));
    }

    public List<Actor> findActorsByEvents() {
        List<Actor> actors = actorRepository.findAll();

        for (Actor a: actors) {
            List<Event> events = eventService.findEventsByActor(a);
            a.setTotalEvents(events.size());
            a.setLastEventTime(this.getLastEventTimestamp(events));
        }

        Collections.sort(actors);

        return actors;
    }

    public Actor update(Actor actor) {
        Actor actorRepo = this.findById(actor.getId());
        if (!actorRepo.getName().equals(actor.getName())) {
            throw new RuntimeException(String.format("%s, sorry, but you cannot update your name, just the avatar",
                    actorRepo.getName()));
        }
        return actorRepository.save(actor);
    }

    private Timestamp getLastEventTimestamp(List<Event> events) throws NoSuchElementException{
        return events.stream()
                .sorted(Comparator.comparingLong(Event::getId).reversed())
                .reduce((first, second) -> second)
                    .orElseThrow(() -> new NoSuchElementException("Error while processing..."))
                .getCreatedAt();
    }

}

