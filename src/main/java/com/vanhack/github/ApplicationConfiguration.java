package com.vanhack.github;

import com.vanhack.github.domain.Actor;
import com.vanhack.github.domain.Event;
import com.vanhack.github.domain.Repo;
import com.vanhack.github.service.ActorService;
import com.vanhack.github.service.EventService;
import com.vanhack.github.service.RepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;

@Component
public class ApplicationConfiguration implements CommandLineRunner {

    private ActorService actorService;
    private EventService eventService;
    private RepoService repoService;

    @Autowired
    public ApplicationConfiguration(ActorService actorService, EventService eventService, RepoService repoService){
        this.actorService = actorService;
        this.eventService = eventService;
        this.repoService = repoService;
    }

    @Override
    public void run(String... args) throws Exception {
        Timestamp t1 = Timestamp.valueOf("2019-01-29 00:11:49.125");
        Timestamp t2 = Timestamp.valueOf("2019-01-28 00:08:23.615");
        Timestamp t3 = Timestamp.valueOf("2019-01-27 00:10:00.665");

        Actor rafael = Actor.of("rribeiro1", "Rafael Ribeiro", "http://avatar.com/rribeiro1");
        Actor jussara = Actor.of("jussara12", "Jussara Cardoso", "http://avatar.com/jussara12");
        Actor leornardo = Actor.of("leonardomso", "Aline Silva", "http://avatar.com/leonardomso");

        Repo repo1 = Repo.of((long) 1, "http://github/rribeiro1/vanhack-challenge");
        Repo repo2 = Repo.of((long) 2, "http://github/jussara12/test");

        actorService.save(rafael);
        actorService.save(leornardo);
        actorService.save(jussara);

        repoService.save(repo1);
        repoService.save(repo2);

        eventService.save(Event.of((long) 1, "push", rafael, repo1, t1));
        eventService.save(Event.of((long) 2, "commit", rafael, repo1, t1));
        eventService.save(Event.of((long) 3, "merge request", rafael, repo1, t1));
        eventService.save(Event.of((long) 4, "pull request", leornardo, repo1, t2));
        eventService.save(Event.of((long) 5, "pull request", leornardo, repo1, t2));
        eventService.save(Event.of((long) 6, "pull request", jussara, repo2, t3));
        eventService.save(Event.of((long) 7, "pull request", jussara, repo2, t3));
        eventService.save(Event.of((long) 8, "pull request", jussara, repo2, Timestamp.from(Instant.now())));
    }
}
