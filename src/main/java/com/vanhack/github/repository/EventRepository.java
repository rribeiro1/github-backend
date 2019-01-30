package com.vanhack.github.repository;

import com.vanhack.github.domain.Actor;
import com.vanhack.github.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, String> {
    List<Event> findByActor(Actor actor);
}
