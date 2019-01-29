package com.vanhack.github.controller;

import com.vanhack.github.domain.Actor;
import com.vanhack.github.domain.Event;
import com.vanhack.github.service.ActorService;
import com.vanhack.github.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/events")
    public List<Event> findAllEvents() {
        return eventService.findAll();
    }
}
