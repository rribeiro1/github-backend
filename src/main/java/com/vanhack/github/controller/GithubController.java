package com.vanhack.github.controller;

import com.vanhack.github.domain.Actor;
import com.vanhack.github.domain.Event;
import com.vanhack.github.service.ActorService;
import com.vanhack.github.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/github/v1/")
public class GithubController {

    private ActorService actorService;
    private EventService eventService;

    @Autowired
    public GithubController(ActorService actorService, EventService eventService) {
        this.actorService = actorService;
        this.eventService = eventService;
    }

    @GetMapping("/actors")
    public List<Actor> findAllActors() {
        return actorService.findAll();
    }

    @PatchMapping("/actors")
    public Actor updateActor(@RequestBody Actor actor) {
        return actorService.update(actor);
    }

    @GetMapping("/events/actors/{actorId}")
    public List<Event> findByActor(@PathVariable String actorId) {
        return eventService.findEventsByActor(actorService.findById(actorId));
    }

    @GetMapping("/events")
    public List<Event> findAllEvents() {
        return eventService.findAll();
    }

    @PostMapping("/events")
    @ResponseStatus(HttpStatus.CREATED)
    public Event createEvent(@RequestBody Event event) {
        return eventService.save(event);
    }

    @DeleteMapping("/events")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllEvents() {
        eventService.deleteAll();
    }

}
