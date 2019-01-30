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

    public Actor findById(String id) {
        if (actorRepository.existsById(id))
            return actorRepository.findById(id).get();
        else
            throw new ResourceNotFoundException(String.format("Actor with ID '%s' does not exists", id));
    }

    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    public Actor update(Actor actor) {
        Actor actorRepo = this.findById(actor.getId());
        if (!actorRepo.getName().equals(actor.getName())) {
            throw new RuntimeException(String.format("%s, sorry, but you cannot update your name, just the avatar",
                    actorRepo.getName()));
        }
        return actorRepository.save(actor);
    }

}

