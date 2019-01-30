package com.vanhack.github;

import com.vanhack.github.domain.Actor;
import com.vanhack.github.domain.Event;
import com.vanhack.github.service.ActorService;
import com.vanhack.github.service.EventService;
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

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Timestamp t1 = Timestamp.valueOf("2019-01-29T00:11:49.125+0000");
		Timestamp t2 = Timestamp.valueOf("2019-01-28T00:08:23.615+0000");
		Timestamp t3 = Timestamp.valueOf("2019-01-27T00:10:00.665+0000");

		Actor rafael = new Actor("rribeiro1", "Rafael Ribeiro");
		Actor leornardo = new Actor("leonardomso", "Leonardo Silva");
		Actor jussara = new Actor("jussara12", "Jussara Cardoso");

		actorService.save(rafael);
		actorService.save(leornardo);

		eventService.save(new Event("1", "push", rafael, t1));
		eventService.save(new Event("2", "commit", rafael, t2));
		eventService.save(new Event("3", "merge request", rafael, t3));
		eventService.save(new Event("4", "pull request", leornardo, Timestamp.from(Instant.now())));
		eventService.save(new Event("5", "pull request", leornardo, Timestamp.from(Instant.now())));
		eventService.save(new Event("6", "pull request", jussara, Timestamp.from(Instant.now())));
		eventService.save(new Event("7", "pull request", jussara, Timestamp.from(Instant.now())));
		eventService.save(new Event("8", "commit", jussara, Timestamp.from(Instant.now())));
		eventService.save(new Event("9", "push", jussara, Timestamp.from(Instant.now())));
	}
}
