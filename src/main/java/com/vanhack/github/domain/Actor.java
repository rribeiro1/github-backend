package com.vanhack.github.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Actor implements Comparable<Actor> {

    @Id
    private String id;

    @Column
    private String name;

    @Column
    private String avatarUrl;

    @JsonIgnore
    private Integer totalEvents;

    @JsonIgnore
    private Timestamp lastEventTime;

    protected Actor() {}

    private Actor(String id, String name, String avatarUrl) {
        this.id = id;
        this.name = name;
        this.avatarUrl = avatarUrl;
    }

    public static Actor of(String id, String name, String avatarUrl) {
        return new Actor(id, name, avatarUrl);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Integer getTotalEvents() {
        return totalEvents;
    }

    public void setTotalEvents(Integer totalEvents) {
        this.totalEvents = totalEvents;
    }

    public Timestamp getLastEventTime() {
        return lastEventTime;
    }

    public void setLastEventTime(Timestamp lastEventTime) {
        this.lastEventTime = lastEventTime;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", totalEvents=" + totalEvents +
                ", lastEventTime=" + lastEventTime +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int compareTo(Actor o) {
        if (this.getTotalEvents().equals(o.getTotalEvents())) {
            if (this.getLastEventTime().before(o.getLastEventTime())) {
                return -1;
            } else {
                if (this.getLastEventTime().after(o.getLastEventTime())) {
                    return 1;
                }
            }
        }
        if (this.getTotalEvents() > o.getTotalEvents()) {
            return -1;
        }
        if (this.getTotalEvents() < o.getTotalEvents()) {
            return 1;
        }
        return 0;
    }
}
