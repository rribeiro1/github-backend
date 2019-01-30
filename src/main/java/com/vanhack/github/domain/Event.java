package com.vanhack.github.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.sql.Timestamp;

@Entity
public class Event {

    @Id
    private Long id;
    @Column
    private String type;
    @OneToOne
    private Actor actor;
    @Column
    private Timestamp createdAt;

    public Event(Long id, String type, Actor actor, Timestamp createdAt) {
        this.id = id;
        this.type = type;
        this.actor = actor;
        this.createdAt = createdAt;
    }

    public Event() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
