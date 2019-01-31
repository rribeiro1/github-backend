package com.vanhack.github;

import com.vanhack.github.domain.Actor;
import com.vanhack.github.domain.Event;
import com.vanhack.github.domain.Repo;
import com.vanhack.github.service.ActorService;
import com.vanhack.github.service.EventService;
import com.vanhack.github.service.RepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;
import java.time.Instant;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private ActorService actorService;

	@Autowired
	private EventService eventService;

	@Autowired
	private RepoService repoService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Timestamp t1 = Timestamp.valueOf("2019-01-29 00:11:49.125");
		Timestamp t2 = Timestamp.valueOf("2019-01-28 00:08:23.615");
		Timestamp t3 = Timestamp.valueOf("2019-01-27 00:10:00.665");

		Actor rafael = Actor.of("rribeiro1", "Rafael Ribeiro", "http://avatar.com/rribeiro1");
		Actor jussara = Actor.of("jussara12", "Jussara Cardoso", "http://avatar.com/jussara12");
		Actor leornardo = Actor.of("leonardomso", "Aline Silva", "http://avatar.com/leonardomso");

		Repo repo1 = Repo.of(Long.valueOf(1), "http://github/rribeiro1/vanhack-challenge");
		Repo repo2 = Repo.of(Long.valueOf(2), "http://github/jussara12/test");

		actorService.save(rafael);
		actorService.save(leornardo);
		actorService.save(jussara);

		repoService.save(repo1);
		repoService.save(repo2);

		eventService.save(Event.of(Long.valueOf(1), "push", rafael, repo1, t1));
		eventService.save(Event.of(Long.valueOf(2), "commit", rafael, repo1, t1));
		eventService.save(Event.of(Long.valueOf(3), "merge request", rafael, repo1, t1));
		eventService.save(Event.of(Long.valueOf(4), "pull request", leornardo, repo1, t2));
		eventService.save(Event.of(Long.valueOf(5), "pull request", leornardo, repo1, t2));
		eventService.save(Event.of(Long.valueOf(6), "pull request", jussara, repo2, t3));
		eventService.save(Event.of(Long.valueOf(7), "pull request", jussara, repo2, Timestamp.from(Instant.now())));
	}
}

