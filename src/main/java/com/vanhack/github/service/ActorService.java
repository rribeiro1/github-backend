package com.vanhack.github.service;

import com.vanhack.github.domain.Actor;
import com.vanhack.github.controller.exception.ResourceNotFoundException;
import com.vanhack.github.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {

    private ActorRepository actorRepository;

    @Autowired
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public Actor save(Actor actor) {
        return actorRepository.save(actor);
    }

    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    public Actor findById(String id) {
        if (actorRepository.existsById(id))
            return actorRepository.findById(id).get();
        else
            throw new ResourceNotFoundException(String.format("Actor with ID: %s does not exists", id));
    }
}

